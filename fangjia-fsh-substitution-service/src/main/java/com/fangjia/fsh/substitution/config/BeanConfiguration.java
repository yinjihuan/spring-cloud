package com.fangjia.dashboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import feign.Logger;

@Configuration
public class BeanConfiguration {
	@Bean  
    Logger.Level feignLoggerLevel() {  
        return Logger.Level.FULL;  
    }  
}
