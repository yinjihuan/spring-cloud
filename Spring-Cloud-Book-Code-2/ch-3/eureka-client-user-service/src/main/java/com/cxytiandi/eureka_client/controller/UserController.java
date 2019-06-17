package com.cxytiandi.eureka_client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/user/hello")
	public String hello() {
		return "hello";
	}
	
}
