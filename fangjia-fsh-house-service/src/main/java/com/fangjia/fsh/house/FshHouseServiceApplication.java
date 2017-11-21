package com.fangjia.fsh.house;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 房生活-房产服务-启动入口
 *
 * @author yinjihuan
 * @date 2017/10/26
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableFeignClients
@ComponentScan(basePackages={"com.fangjia"})
public class FshHouseServiceApplication {
    public static ConfigurableApplicationContext context = null;
    public static void main(String[] args) {
        System.setProperty("smconf.conf.package", "com.fangjia.fsh.house.config");
        context = SpringApplication.run(FshHouseServiceApplication.class, args);
    }
    
}
