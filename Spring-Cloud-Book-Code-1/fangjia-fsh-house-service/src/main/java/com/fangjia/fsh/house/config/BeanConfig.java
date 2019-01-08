package com.fangjia.fsh.house.config;

import org.cxytiandi.conf.client.init.ConfInit;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cxytiandi.jdbc.CxytiandiJdbcTemplate;
import com.fangjia.common.aspect.ApiLimitAspect;
import com.fangjia.fsh.house.listener.InitGatewayApiLimitRateListener;

/**
 * 配置信息
 *
 * @author yinjihuan
 * @create 2017-11-20 18:10
 **/
@Configuration
public class BeanConfig {

    /**
     * JDBC
     * @return
     */
    @Bean(autowire= Autowire.BY_NAME)
    public CxytiandiJdbcTemplate cxytiandiJdbcTemplate() {
        return new CxytiandiJdbcTemplate("com.fangjia.fsh.house.po");
    }

    /**
     * 具体的API并发控制
     * @return
     */
    @Bean
    public ApiLimitAspect apiLimitAspect() {
        return new ApiLimitAspect();
    }

    @Bean
    public InitGatewayApiLimitRateListener initGatewayApiLimitRateListener() {
		return new InitGatewayApiLimitRateListener("com.fangjia.fsh.house.controller");
	}
    
    @Bean
    public ConfInit confInit() {
    	return new ConfInit();
    }
}
