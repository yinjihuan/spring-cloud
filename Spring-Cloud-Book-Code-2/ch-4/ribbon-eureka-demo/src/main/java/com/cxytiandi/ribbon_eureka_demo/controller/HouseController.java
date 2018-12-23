package com.cxytiandi.ribbon_eureka_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxytiandi.ribbon_eureka_demo.dto.HouseInfo;



@RestController
public class HouseController {

	@GetMapping("/house/data") 	
	public HouseInfo getData(@RequestParam("name") String name) { 	
	    return new HouseInfo(1L, "上海", "虹口", "东体小区"); 	
	}  
	
	@GetMapping("/house/data/{name}") 	
	public String getData2(@PathVariable("name") String name) { 	 
	    return name; 	
	} 
	
	@PostMapping("/house/save")
	public Long addData(@RequestBody HouseInfo houseInfo) {       
		System.out.println(houseInfo.getName());       
		return 1001L; 
	}


}
