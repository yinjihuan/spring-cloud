package com.fangjia.fsh.api;

import org.cxytiandi.conf.client.init.SmconfInit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

/**
 * API网关
 * @author yinjihuan
 */
@SpringBootApplication
@EnableZuulProxy
@EnableFeignClients(basePackages = "com.fangjia.api.client")
@ComponentScan(basePackages = "com.fangjia")
public class ZuulApplication {
  public static void main(String[] args) {
    SpringApplication.run(ZuulApplication.class, args);
  }
}