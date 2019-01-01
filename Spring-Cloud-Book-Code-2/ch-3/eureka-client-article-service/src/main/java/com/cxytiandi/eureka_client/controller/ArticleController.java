package com.cxytiandi.eureka_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;

@RestController
public class ArticleController {

	@Autowired 	
	private RestTemplate restTemplate;  	

	@Autowired     
	private DiscoveryClient discoveryClient;     

	@Autowired
	private EurekaClient eurekaClient;
	
	@GetMapping("/article/infos")     
	public Object serviceUrl() {     
		return eurekaClient.getInstancesByVipAddress("eureka-client-user-service", false);
		//return discoveryClient.getInstances("eureka-client-user-service");     
	}

	@GetMapping("/article/callHello") 	
	public String callHello() { 		
	    return restTemplate.getForObject(
			"http://localhost:8081/user/hello", String.class); 	
	}
	
	@GetMapping("/article/callHello2") 	
	public String callHello2() { 		
	    return restTemplate.getForObject(
			"http://eureka-client-user-service/user/hello", String.class); 	
	}
	
}
