package com.cxytiandi.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UserPorperties.class)
public class UserAutoConfigure {

	@Bean
	@ConditionalOnProperty(prefix = "spring.user",value = "enabled",havingValue = "true")
	public UserClient userClient(UserPorperties userPorperties) {
		return new UserClient(userPorperties);
	}
	
}
