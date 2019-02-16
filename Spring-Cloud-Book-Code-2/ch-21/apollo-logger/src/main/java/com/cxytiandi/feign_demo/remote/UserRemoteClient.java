package com.cxytiandi.feign_demo.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.cxytiandi.feign_demo.config.FeignConfiguration;

@FeignClient(value="eureka-client-user-service", configuration=FeignConfiguration.class)
public interface UserRemoteClient {

	@GetMapping("/user/hello") 
	String hello();
	
}
