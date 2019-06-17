package com.cxytiandi.ribbon_eureka_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cxytiandi.ribbon_eureka_demo.dto.HouseInfo;


@RestController
public class HouseClientController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired 	
	private LoadBalancerClient loadBalancer;  	

	@GetMapping("/choose") 	
	public Object chooseUrl() { 		
		ServiceInstance instance = loadBalancer.choose("ribbon-eureka-demo");
		return instance; 	
	}

	@GetMapping("/call/data")     
	public HouseInfo getData(@RequestParam("name") String name) {         
	    return restTemplate.getForObject(
		"http://ribbon-eureka-demo/house/data?name="+name, HouseInfo.class);     
	}       

	@GetMapping("/call/data/{name}")     
	public String getData2(@PathVariable("name") String name) {         
	    return restTemplate.getForObject(
		"http://ribbon-eureka-demo/house/data/{name}", String.class, name);     
	}
	
	@GetMapping("/call/dataEntity")     
	public HouseInfo getDataEntity(@RequestParam("name") String name) {         
		ResponseEntity<HouseInfo> responseEntity = restTemplate.getForEntity(
			"http://ribbon-eureka-demo/house/data?name="+name, HouseInfo.class);         
		if(responseEntity.getStatusCodeValue() == 200) {             
		    return responseEntity.getBody();         
		}         
		return null;               
	} 

	@GetMapping("/call/save") 
	public Long add() {       
		HouseInfo houseInfo = new HouseInfo();       
		houseInfo.setCity("上海");       
		houseInfo.setRegion("虹口");       
		houseInfo.setName("XXX");       
		Long id = restTemplate.postForObject(
			"http://ribbon-eureka-demo/house/save", houseInfo, Long.class);       
		return id; 
	}


}
