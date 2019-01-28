package com.cxytiandi.zuul_demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
public class BasicConf {
	
	// API接口白名单，多个用逗号分隔
	@Value("${apiWhiteStr:/user/login}")
	private String apiWhiteStr;

}
