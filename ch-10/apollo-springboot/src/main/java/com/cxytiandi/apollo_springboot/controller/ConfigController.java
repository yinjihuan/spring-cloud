package com.cxytiandi.apollo_springboot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.ApolloJsonValue;
import com.cxytiandi.apollo_springboot.config.RedisConfig;
import com.cxytiandi.apollo_springboot.config.Student;
import com.cxytiandi.apollo_springboot.config.UserConfig;

@RestController
public class ConfigController {

	@Autowired
	private UserConfig userConfig;
	
	/**
	 * 用户名，默认值为yinjihuan
	 */
	@Value("${username:yinjihuan}")
	private String username;
	
	@Autowired
	private RedisConfig redisConfig;
	
	@ApolloConfig
	private Config config;
	 
	@ApolloJsonValue("${stus:[]}")
	private List<Student> stus;
	
	@GetMapping("/config/stus")
	public List<Student> stus() {
		return stus;
	}
	
	@GetMapping("/config/getUserName3")
	public String getUserName3() {
		return config.getProperty("username", "yinjihuan");
	}
	
	@GetMapping("/config/getUserName")
	public String getUserName() {
		return username;
	}
	
	@GetMapping("/config/getUserName2")
	public String getUserName2() {
		return userConfig.getUsername();
	}
	
	@GetMapping("/config/getRedisConfig")
	public String getRedisConfig() {
		return redisConfig.getHost();
	}
	
	@ApolloConfigChangeListener
	private void someOnChange(ConfigChangeEvent changeEvent) {
		if(changeEvent.isChanged("username")) {
			System.out.println("username发生修改了");
		}
	}
	 
}
