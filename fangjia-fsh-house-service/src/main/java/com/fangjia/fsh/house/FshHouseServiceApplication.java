package com.fangjia.fsh.house;

import com.fangjia.common.base.StartCommand;
import com.fangjia.common.listenter.InitApiLimitRateListener;
import com.fangjia.fsh.house.listener.InitGatewayApiLimitRateListener;

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
@ComponentScan(basePackages={"com.fangjia"})
//@EnableFeignClients(basePackages = "com.fangjia.mqclient")
public class FshHouseServiceApplication {
    public static ConfigurableApplicationContext context = null;
    public static void main(String[] args) {
        // 启动参数设置，比如自动生成端口
        //new StartCommand(args);
        // 启动时初始化配置信息
    	System.setProperty("smconf.conf.package", "com.fangjia.fsh.house.conf");
        SpringApplication application = new SpringApplication(FshHouseServiceApplication.class);
        //application.addListeners(new InitApiLimitRateListener("com.fangjia.fsh.house.controller"));
        application.addListeners(new InitGatewayApiLimitRateListener("com.fangjia.fsh.house.controller"));
        context = application.run(args);
    }
}
