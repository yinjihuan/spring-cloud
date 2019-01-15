package com.cxytiandi.spring_cloud_gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Mono;

@Configuration
public class BeanConfig {
	@Bean
	public KeyResolver ipKeyResolver() {
		return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
	}
}
