package com.cxytiandi.apollo_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Apollo整合Spring Boot示列
 * 
 * @author yinjihuan
 * 
 * @about http://cxytiandi.com/about
 * 
 * @date 2018-12-16
 * 
 */
@SpringBootApplication
public class App {
	public static void main(String[] args) {
		// 指定环境（开发演示用，不能用于生产环境））
		System.setProperty("env", "DEV");
		SpringApplication.run(App.class, args);
	}
}
