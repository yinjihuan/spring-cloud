package com.fangjia.fsh.substitution.config;

import com.fangjia.fsh.substitution.rule.MyLoadBalanced;
import com.fangjia.fsh.substitution.rule.MyRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import feign.Logger;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfiguration {
	@Bean  
    Logger.Level feignLoggerLevel() {  
        return Logger.Level.FULL;  
    }

    @Bean
    //@LoadBalanced
    @MyLoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /*@Bean
    public MyRule rule() {
	    return new MyRule();
    }*/
}
