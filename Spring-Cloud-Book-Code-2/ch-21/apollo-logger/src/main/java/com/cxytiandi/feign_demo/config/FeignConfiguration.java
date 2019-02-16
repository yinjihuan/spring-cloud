package com.cxytiandi.feign_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import feign.Logger;

@Configuration
public class FeignConfiguration {
	/**
	 * 日志级别
	 * 
	 * @return
	 */
	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}
}
