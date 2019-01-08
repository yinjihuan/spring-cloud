package com.cxytiandi.ribbon_eureka_demo.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.cxytiandi.ribbon_eureka_demo.rule.MyRule;

@Configuration
public class BeanConfiguration {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	//@Bean     
	public MyRule rule() { 	    
	    return new MyRule();     
	} 

}
