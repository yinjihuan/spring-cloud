package com.cxytiandi.feign_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cxytiandi.feign_demo.auth.FeignBasicAuthRequestInterceptor;

import feign.Logger;
import feign.Request;
import feign.auth.BasicAuthRequestInterceptor;

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

	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		return new BasicAuthRequestInterceptor("user", "password");
	}

	@Bean
	public FeignBasicAuthRequestInterceptor feignBasicAuthRequestInterceptor() {
		return new FeignBasicAuthRequestInterceptor();
	}

	@Bean
	public Request.Options options() {
		return new Request.Options(5000, 10000);
	}

}
