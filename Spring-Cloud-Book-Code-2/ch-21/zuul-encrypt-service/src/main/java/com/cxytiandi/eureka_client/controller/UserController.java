package com.cxytiandi.eureka_client.controller;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxytiandi.eureka_client.User;

@RestController
public class UserController {

	@GetMapping("/user/hello")
	public String hello() {
		return "hello";
	}
	
	@PostMapping("/user")
	public String save(@RequestBody User user) {
		return user.getName();
	}
	
	AtomicInteger ac = new AtomicInteger();

	@GetMapping("/data")
	public String getData(@RequestParam("name") String name) {
		 System.err.println(ac.addAndGet(1));
	    if (StringUtils.hasText(name)) {
	        throw new RuntimeException("error");
	    }
	    return "success";
	}
}
