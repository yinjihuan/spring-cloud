package com.cxytiandi.apollo_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Apollo整合Zuul动态刷新路由示列
 * 
 * @author yinjihuan
 * 
 * @about http://cxytiandi.com/about
 * 
 * @date 2019-01-18
 * 
 */
@EnableZuulProxy
@SpringBootApplication
public class App {
	public static void main(String[] args) {
		// 指定环境（开发演示用，不能用于生产环境））
		System.setProperty("env", "DEV");
		SpringApplication.run(App.class, args);
	}
}
