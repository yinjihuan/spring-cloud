package com.cxytiandi.ribbon_eureka_demo.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.cxytiandi.ribbon_eureka_demo.loadbalanced.MyLoadBalanced;

@Configuration
public class BeanConfiguration {

	@Bean
	//@LoadBalanced
	@MyLoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
