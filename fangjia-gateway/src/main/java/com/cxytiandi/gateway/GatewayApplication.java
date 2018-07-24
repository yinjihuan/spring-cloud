package com.cxytiandi.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Mono;
/**
 * 网关启动入口
 * 
 * @author yinjihuan
 * 
 * @about http://cxytiandi.com/about
 *
 */
@SpringBootApplication
public class GatewayApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	
	//@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
	    return builder.routes()
	            .route(r -> r.path("/course").uri("http://cxytiandi.com"))
	            .build();
	}
	
	@Bean
	public KeyResolver ipKeyResolver() {
		return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
	}
	
//	@Bean
//	KeyResolver ipKeyResolver() {
//	    //return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"));
//		return exchange -> Mono.just("cxytiandi");
//		//return exchange -> Mono.just(exchange.getRequest().getPath().value());
//	    
//	}
}
