package com.cxytiandi.feignapi.user;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("feign-inherit-provide")
public interface UserRemoteClient {
	
	@GetMapping("/user/name")
	String getName();
	
	@GetMapping("/user/info")
	String getUserInfo(@RequestParam("name")String name);
	
	@GetMapping("/user/detail")
	String getUserDetail(@RequestParam Map<String, Object> param);
	
	@PostMapping("/user/add")
	String addUser(@RequestBody User user);
	
}
