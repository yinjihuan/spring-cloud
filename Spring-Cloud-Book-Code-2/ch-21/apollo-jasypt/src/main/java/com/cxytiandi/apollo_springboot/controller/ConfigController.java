package com.cxytiandi.apollo_springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;

@RestController
public class ConfigController {
	
	@Value("${test.input}")
	private String input;
	
	@ApolloConfig
	private Config config;
	 
	/**
	 * Config使用无法解密
	 * @return
	 */
	@GetMapping("/config/getUserName3")
	public String getUserName3() {
		return config.getProperty("test.input", "yinjihuan");
	}
	
	/**
	 * Spring注入可以解密
	 * @return
	 */
	@GetMapping("/config/getUserName")
	public String getUserName() {
		return input;
	}
	
}
