package com.fangjia.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 微服务之间直接调用的认证中心
 * @author yinjihuan
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AuthApplication {
	public static void main(String[] args) {
	    SpringApplication.run(AuthApplication.class, args);
	}
}
