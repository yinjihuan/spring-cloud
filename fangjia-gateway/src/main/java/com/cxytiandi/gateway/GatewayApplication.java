package com.cxytiandi.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
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
	
}
