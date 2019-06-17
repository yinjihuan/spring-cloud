package com.cxytiandi.zuul_demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.cxytiandi.zuul_demo.filter.LimitFilter;
import com.google.common.util.concurrent.RateLimiter;

import lombok.Data;

@Data
@Configuration
public class BasicConf {
	
	// API接口白名单，多个用逗号分隔
	@Value("${apiWhiteStr:/zuul-extend-user-service/user/login}")
	private String apiWhiteStr;

	@Value("${limitRate:10}")
	private double limitRate;
	
	@Value("${api.clusterLimitRate:100}")
	private int clusterLimitRate;
	 
	@Value("${downGradeServiceStr:default}")
	private String downGradeServiceStr;

	@Value("${grayPushServers:default}")
	private String grayPushServers;

	@Value("${grayPushUsers:default}")
	private String grayPushUsers;
	
	@ApolloConfig
	private Config config;
	
	@ApolloConfigChangeListener
	public void onChange(ConfigChangeEvent changeEvent) {
		if (changeEvent.isChanged("limitRate")) {
			// 更 新 RateLimiter
			System.err.println(config.getDoubleProperty("limitRate", 10.0));
			LimitFilter.rateLimiter = RateLimiter.create(config.getDoubleProperty("limitRate", 10.0));
		}
	}
	
}
