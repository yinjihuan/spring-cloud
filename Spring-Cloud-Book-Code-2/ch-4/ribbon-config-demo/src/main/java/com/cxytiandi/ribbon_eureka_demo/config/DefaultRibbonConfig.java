package com.cxytiandi.ribbon_eureka_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class DefaultRibbonConfig {
	
	@Bean
	public IRule ribbonRule() {
		return new RandomRule();
	}

}
