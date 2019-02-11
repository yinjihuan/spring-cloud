package com.cxytiandi.mysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxytiandi.mysql.service.LdService;

@RestController
public class LdController {

	@Autowired
	private LdService ldService;
	
	@GetMapping("/test")
	public String test() {
		System.err.println(ldService.count());
		return "success";
	}
}
