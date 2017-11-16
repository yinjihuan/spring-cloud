package com.fangjia.fsh.api.config;

import org.cxytiandi.conf.client.init.ConfInit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
	
	/**
	 * 启动Smconf配置客户端
	 * @return
	 */
	@Bean
	public ConfInit confInit() {
	    return new ConfInit();
	}
	
}
