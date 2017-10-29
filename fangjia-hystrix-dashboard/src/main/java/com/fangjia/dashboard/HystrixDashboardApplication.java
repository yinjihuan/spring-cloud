package com.fangjia.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * 熔断器监控-启动入口
 *
 * @author yinjihuan
 * @date 2017/10/26
 */
@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
@EnableTurbine
public class HystrixDashboardApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication.class, args);
    }
    
}
