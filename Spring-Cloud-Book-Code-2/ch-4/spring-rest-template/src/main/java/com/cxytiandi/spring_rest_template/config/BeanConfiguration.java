package com.cxytiandi.spring_rest_template.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfiguration {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
