package com.cxytiandi.feign_demo.remote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

@Component
public class UserRemoteClientFallbackFactory implements FallbackFactory<UserRemoteClient> {

	private Logger logger = LoggerFactory.getLogger(UserRemoteClientFallbackFactory.class);
	
	@Override
	public UserRemoteClient create(Throwable cause) {
		logger.error("UserRemoteClient回退：", cause);
		return new UserRemoteClient() {
			
			@Override
			public String hello() {
				return "fail";
			}
		};
	}

}
