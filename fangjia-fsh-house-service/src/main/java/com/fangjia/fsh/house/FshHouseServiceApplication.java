package com.fangjia.fsh.house;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 房生活-房产服务-启动入口
 *
 * @author yinjihuan
 * @date 2017/10/26
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FshHouseServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FshHouseServiceApplication.class, args);
    }
}
