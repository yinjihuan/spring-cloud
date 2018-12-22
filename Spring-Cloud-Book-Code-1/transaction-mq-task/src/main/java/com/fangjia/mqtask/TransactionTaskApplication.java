package com.fangjia.mqtask;

import java.util.concurrent.CountDownLatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.fangjia.mqclient")
@SpringBootApplication
public class TransactionTaskApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionTaskApplication.class);
	
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(TransactionTaskApplication.class);
		ConfigurableApplicationContext content = application.run(args);
        try {
        	ProcessMessageTask task = content.getBean(ProcessMessageTask.class);
        	task.start();
        	new CountDownLatch(1).await();
		} catch (InterruptedException e) {
			LOGGER.error("项目启动异常", e);
		}
	}
}
