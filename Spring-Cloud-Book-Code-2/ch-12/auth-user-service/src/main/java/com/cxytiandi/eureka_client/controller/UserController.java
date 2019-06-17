package com.cxytiandi.eureka_client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("/user/hello")
	public String hello() {
		logger.info("我是/user/hello");
		return "hello";
	}
	
}
