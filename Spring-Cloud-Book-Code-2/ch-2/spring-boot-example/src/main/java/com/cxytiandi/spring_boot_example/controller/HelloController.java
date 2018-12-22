package com.cxytiandi.spring_boot_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxytiandi.spring_boot_example.config.MyConfig;
import com.cxytiandi.spring_boot_example.service.LogService;

@RestController
public class HelloController {

	// 注入对象
	@Autowired
	private Environment env;

	// 注入配置 	
	@Value("${server.port}") 	
	private String port; 

	@Autowired 	
	private MyConfig myConfig;  	

	@Autowired
	private LogService logService;
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/hello2")
	public String hello2() {
		// 读取配置
		String port = env.getProperty("server.port");
		return port;
	}
	
	@GetMapping("/hello3")
	public String hello3() {
		return port;
	}
	
	@GetMapping("/hello4")
	public String hello4() {
		return myConfig.getName(); 
	}
	
	@GetMapping("/async")
	public String async() {
		logService.saveLog();
		return "success";
	}

}
