package com.cxytiandi.springcloud_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class HellController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/callHello")
	@HystrixCommand(fallbackMethod = "defaultCallHello", commandProperties = {                  
			@HystrixProperty(
					name="execution.isolation.strategy",      
					value = "THREAD")    
			} 
	)
	public String callHello() {
		String result = restTemplate.getForObject("http://localhost:8088/house/hello", String.class);
		return result;
	}

	public String defaultCallHello() {
		return "fail";
	}

}
