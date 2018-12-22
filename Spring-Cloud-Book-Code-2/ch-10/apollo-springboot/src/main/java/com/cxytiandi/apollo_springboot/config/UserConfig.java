package com.cxytiandi.apollo_springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * 自定义Apollo配置类
 * @author yinjihuan
 *
 */
@Data
@Configuration
public class UserConfig {

	@Value("${username:yinjihuan}")
	private String username;
	
}
