package com.cxytiandi.eureka_client.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxytiandi.eureka_client.apilimit.ApiRateLimit;
import com.cxytiandi.eureka_client.feign.UserRemoteClient;

@RestController
public class ArticleController {
	
	@Autowired
	private UserRemoteClient userRemoteClient;
	
	@Autowired
	private HttpServletRequest request;
	
	@ApiRateLimit(confKey = "open.api.callHello")
	@GetMapping("/article/callHello") 	
	public String callHello() {
		System.err.println("用户ID:" + request.getHeader("uid"));
	    return userRemoteClient.hello(); 	
	}
	
}
