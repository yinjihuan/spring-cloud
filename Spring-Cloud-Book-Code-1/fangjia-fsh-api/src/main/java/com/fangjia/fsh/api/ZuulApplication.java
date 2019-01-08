package com.fangjia.fsh.api;

import org.cxytiandi.conf.client.init.SmconfInit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

import com.netflix.hystrix.strategy.HystrixPlugins;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;

/**
 * API网关
 * 
 * @author yinjihuan
 */
@SpringBootApplication
@EnableZuulProxy
@EnableFeignClients(basePackages = "com.fangjia.api.client")
@ComponentScan(basePackages = "com.fangjia")
public class ZuulApplication {
	public static void main(String[] args) {
		//注册自定义线程池
		HystrixPlugins.getInstance().registerConcurrencyStrategy(new ThreadLocalHystrixConcurrencyStrategy());
		SpringApplication.run(ZuulApplication.class, args);
	}
}