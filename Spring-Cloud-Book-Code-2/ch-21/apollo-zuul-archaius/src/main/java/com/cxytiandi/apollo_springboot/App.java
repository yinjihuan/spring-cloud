package com.cxytiandi.apollo_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Apollo整合archaius示列
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
		// 指定archaius获取配置的URL
		String apolloConfigServiceUrl = "http://localhost:8080";
		String appId = "SampleApp";
		System.setProperty("archaius.configurationSource.additionalUrls",
		        apolloConfigServiceUrl + "/configfiles/" + appId + "/default/application");
		SpringApplication.run(App.class, args);
	}
}
