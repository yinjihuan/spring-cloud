package com.cxytiandi.eureka_client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cxytiandi.eureka_client.interceptor.FeignBasicAuthRequestInterceptor;

@Configuration
public class FeignConfiguration {
	/**
	 * 创建Feign请求拦截器，在发送请求前设置认证的token,各个微服务将token设置 到环境变量中来达到通用
	 * 
	 * @return
	 */
	@Bean
	public FeignBasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		return new FeignBasicAuthRequestInterceptor();
	}
}
