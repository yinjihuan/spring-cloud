package com.fangjia.fsh.substitution;

import com.fangjia.common.base.StartCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

/**
 * 房生活-置换服务-启动入口
 *
 * @author yinjihuan
 * @date 2017/10/26
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableFeignClients(basePackages = {"com.fangjia.api.client", "com.fangjia.mqclient"})
@ComponentScan(basePackages = "com.fangjia")
public class FshSubstitutionServiceApplication {
	
    public static void main(String[] args) {
        // 启动参数设置，比如自动生成端口
        new StartCommand(args);
        // 启动时初始化配置信息
        System.setProperty("smconf.conf.package", "com.fangjia.fsh.substitution.conf");
        SpringApplication.run(FshSubstitutionServiceApplication.class, args);
    }

}
