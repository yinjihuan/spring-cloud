package com.cxytiandi.feign_demo.remote;

import org.springframework.stereotype.Component;

@Component
public class UserRemoteClientFallback implements UserRemoteClient {

	@Override
	public String hello() {
		return "fail";
	}

}
