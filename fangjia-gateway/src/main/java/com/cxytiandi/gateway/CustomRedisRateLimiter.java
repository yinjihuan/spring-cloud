package com.cxytiandi.gateway;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.validation.constraints.Min;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.cloud.gateway.filter.ratelimit.AbstractRateLimiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import com.cxytiandi.gateway.conf.RateLimitConf;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CustomRedisRateLimiter extends AbstractRateLimiter<CustomRedisRateLimiter.Config>
		implements ApplicationContextAware {

	public static final String CONFIGURATION_PROPERTY_NAME = "custom-redis-rate-limiter";
	public static final String REDIS_SCRIPT_NAME = "redisRequestRateLimiterScript";
	public static final String REMAINING_HEADER = "X-RateLimit-Remaining";
	public static final String REPLENISH_RATE_HEADER = "X-RateLimit-Replenish-Rate";
	public static final String BURST_CAPACITY_HEADER = "X-RateLimit-Burst-Capacity";

	public CustomRedisRateLimiter(ReactiveRedisTemplate<String, String> redisTemplate, RedisScript<List<Long>> script,
			Validator validator) {
		super(Config.class, CONFIGURATION_PROPERTY_NAME, validator);
		this.redisTemplate = redisTemplate;
		this.script = script;
		initialized.compareAndSet(false, true);
	}

	public CustomRedisRateLimiter(int defaultReplenishRate, int defaultBurstCapacity) {
		super(Config.class, CONFIGURATION_PROPERTY_NAME, null);
		this.defaultConfig = new Config().setReplenishRate(defaultReplenishRate).setBurstCapacity(defaultBurstCapacity);
	}

	private Log log = LogFactory.getLog(getClass());

	private ReactiveRedisTemplate<String, String> redisTemplate;
	private RedisScript<List<Long>> script;
	private AtomicBoolean initialized = new AtomicBoolean(false);
	private Config defaultConfig;
	// 限流配置
	private RateLimitConf rateLimitConf;
	// configuration properties
	/**
	 * Whether or not to include headers containing rate limiter information,
	 * defaults to true.
	 */
	private boolean includeHeaders = true;

	/**
	 * The name of the header that returns number of remaining requests during
	 * the current second.
	 */
	private String remainingHeader = REMAINING_HEADER;

	/** The name of the header that returns the replenish rate configuration. */
	private String replenishRateHeader = REPLENISH_RATE_HEADER;

	/** The name of the header that returns the burst capacity configuration. */
	private String burstCapacityHeader = BURST_CAPACITY_HEADER;

	public boolean isIncludeHeaders() {
		return includeHeaders;
	}

	public void setIncludeHeaders(boolean includeHeaders) {
		this.includeHeaders = includeHeaders;
	}

	public String getRemainingHeader() {
		return remainingHeader;
	}

	public void setRemainingHeader(String remainingHeader) {
		this.remainingHeader = remainingHeader;
	}

	public String getReplenishRateHeader() {
		return replenishRateHeader;
	}

	public void setReplenishRateHeader(String replenishRateHeader) {
		this.replenishRateHeader = replenishRateHeader;
	}

	public String getBurstCapacityHeader() {
		return burstCapacityHeader;
	}

	public void setBurstCapacityHeader(String burstCapacityHeader) {
		this.burstCapacityHeader = burstCapacityHeader;
	}

	public CustomRedisRateLimiter() {
		super(Config.class, CONFIGURATION_PROPERTY_NAME, null);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		// 加载配置
		this.rateLimitConf = context.getBean(RateLimitConf.class);
		if (initialized.compareAndSet(false, true)) {
			this.redisTemplate = context.getBean("stringReactiveRedisTemplate", ReactiveRedisTemplate.class);
			this.script = context.getBean(REDIS_SCRIPT_NAME, RedisScript.class);
			if (context.getBeanNamesForType(Validator.class).length > 0) {
				this.setValidator(context.getBean(Validator.class));
			}
		}
	}

	/* for testing */ Config getDefaultConfig() {
		return defaultConfig;
	}

	/**
	 * This uses a basic token bucket algorithm and relies on the fact that
	 * Redis scripts execute atomically. No other operations can run between
	 * fetching the count and writing the new count.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Mono<Response> isAllowed(String routeId, String id) {
		if (!this.initialized.get()) {
			throw new IllegalStateException("RedisRateLimiter is not initialized");
		}

		//Config routeConfig = getConfig().getOrDefault(routeId, defaultConfig);
		
		if (rateLimitConf == null) {
			throw new IllegalArgumentException("No Configuration found for route " + routeId);
		}
		Map<String,Integer> routeConfig = rateLimitConf.getLimitMap();

		// Key的格式：服务名称.接口URI.类型
		String replenishRateKey = routeId + "." + id + ".replenishRate";
		int replenishRate = routeConfig.get(replenishRateKey) == null ? routeConfig.get("default.replenishRate") : routeConfig.get(replenishRateKey);
		
		String burstCapacityKey = routeId + "." + id + ".burstCapacity";
		int burstCapacity = routeConfig.get(burstCapacityKey) == null ? routeConfig.get("default.burstCapacity") : routeConfig.get(burstCapacityKey);
			
		try {
			List<String> keys = getKeys(id);

			// The arguments to the LUA script. time() returns unixtime in
			// seconds.
			List<String> scriptArgs = Arrays.asList(replenishRate + "", burstCapacity + "",
					Instant.now().getEpochSecond() + "", "1");
			// allowed, tokens_left = redis.eval(SCRIPT, keys, args)
			Flux<List<Long>> flux = this.redisTemplate.execute(this.script, keys, scriptArgs);
			// .log("redisratelimiter", Level.FINER);
			return flux.onErrorResume(throwable -> Flux.just(Arrays.asList(1L, -1L)))
					.reduce(new ArrayList<Long>(), (longs, l) -> {
						longs.addAll(l);
						return longs;
					}).map(results -> {
						boolean allowed = results.get(0) == 1L;
						Long tokensLeft = results.get(1);

						Response response = new Response(allowed, getHeaders(replenishRate, burstCapacity, tokensLeft));

						if (log.isDebugEnabled()) {
							log.debug("response: " + response);
						}
						return response;
					});
		} catch (Exception e) {
			/*
			 * We don't want a hard dependency on Redis to allow traffic. Make
			 * sure to set an alert so you know if this is happening too much.
			 * Stripe's observed failure rate is 0.01%.
			 */
			log.error("Error determining if user allowed from redis", e);
		}
		return Mono.just(new Response(true, getHeaders(replenishRate, burstCapacity, -1L)));
	}

	public HashMap<String, String> getHeaders(Integer replenishRate, Integer burstCapacity, Long tokensLeft) {
		HashMap<String, String> headers = new HashMap<>();
		headers.put(this.remainingHeader, tokensLeft.toString());
		headers.put(this.replenishRateHeader, String.valueOf(replenishRate));
		headers.put(this.burstCapacityHeader, String.valueOf(burstCapacity));
		return headers;
	}

	static List<String> getKeys(String id) {
		// use `{}` around keys to use Redis Key hash tags
		// this allows for using redis cluster

		// Make a unique key per user.
		String prefix = "request_rate_limiter.{" + id;

		// You need two Redis keys for Token Bucket.
		String tokenKey = prefix + "}.tokens";
		String timestampKey = prefix + "}.timestamp";
		return Arrays.asList(tokenKey, timestampKey);
	}

	@Validated
	public static class Config {
		@Min(1)
		private int replenishRate;

		@Min(1)
		private int burstCapacity = 1;

		public int getReplenishRate() {
			return replenishRate;
		}

		public Config setReplenishRate(int replenishRate) {
			this.replenishRate = replenishRate;
			return this;
		}

		public int getBurstCapacity() {
			return burstCapacity;
		}

		public Config setBurstCapacity(int burstCapacity) {
			this.burstCapacity = burstCapacity;
			return this;
		}

		@Override
		public String toString() {
			return "Config{" + "replenishRate=" + replenishRate + ", burstCapacity=" + burstCapacity + '}';
		}
	}

}
