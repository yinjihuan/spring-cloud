package com.cxytiandi.smconf_demo;

import org.cxytiandi.conf.client.init.ConfInit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * Smconf配置中心使用示列
 * 
 * @author yinjihuan
 * 
 * @about http://cxytiandi.com/about
 * 
 * @date 2019-01-13
 * 
 */
@EnableDiscoveryClient
@SpringBootApplication
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
   /**
	*	启动 Smconf 配置客户端
	*	@return
	*/
	@Bean
	public ConfInit confInit() {
		return new ConfInit();
	}

}
