package com.fangjia.fsh.api.config;

import com.fangjia.fsh.api.rule.GrayPushRule;
import com.netflix.loadbalancer.IRule;
import org.cxytiandi.conf.client.init.ConfInit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
//	@Bean
//	public IRule ribbonRule(){
//		return new GrayPushRule();
//	}
	/**
	 * 启动Smconf配置客户端
	 * @return
	 */
	@Bean
	public ConfInit confInit() {
	    return new ConfInit();
	}
	
}
