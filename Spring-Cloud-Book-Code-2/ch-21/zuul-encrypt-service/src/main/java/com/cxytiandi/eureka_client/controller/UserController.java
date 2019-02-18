package com.cxytiandi.eureka_client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
}
