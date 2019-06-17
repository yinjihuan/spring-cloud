package com.cxytiandi.eureka_client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "zuul-extend-user-service") 
public interface UserRemoteClient {
	
   @GetMapping("/user/hello") 
   String hello(); 
   
}