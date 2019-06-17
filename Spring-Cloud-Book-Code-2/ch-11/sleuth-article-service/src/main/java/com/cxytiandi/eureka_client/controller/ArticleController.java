package com.cxytiandi.eureka_client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cxytiandi.eureka_client.service.ArticleService;

import brave.Tracer;

@RestController
public class ArticleController {

	private Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@Autowired 	
	private RestTemplate restTemplate;  	
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired 
	Tracer tracer;
	
	@GetMapping("/article/callHello") 	
	public String callHello() { 		
		logger.info("我是/article/callHello");
		tracer.currentSpan().tag("用户", "yinjihuan");
		articleService.saveLog("test");
		articleService.saveLog2("test");
	    return restTemplate.getForObject(
			"http://sleuth-user-service/user/hello", String.class); 	
	}
	
}
