package com.cxytiandi.eureka_client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cxytiandi.eureka_client.feign.UserRemoteClient;

@RestController
public class ArticleController {

	private Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@Autowired 	
	private RestTemplate restTemplate;  	
	
	@Autowired
	private UserRemoteClient userRemoteClient;
	
	@GetMapping("/article/callHello") 	
	public String callHello() { 		
		logger.info("我是/article/callHello");
	    return restTemplate.getForObject(
			"http://auth-user-service/user/hello", String.class); 	
	}
	
	@GetMapping("/article/callHello2") 	
	public String callHello2() { 		
		logger.info("我是/article/callHello2");
	    return userRemoteClient.hello(); 	
	}
	
}
