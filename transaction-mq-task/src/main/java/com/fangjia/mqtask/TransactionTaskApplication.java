package com.fangjia.mqtask;

import java.util.concurrent.CountDownLatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.cxytiandi"})
public class TransactionTaskApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionTaskApplication.class);
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder()
				.sources(TransactionTaskApplication.class).web(false).run(args);
        try {
        	ProcessMessageTask task = context.getBean(ProcessMessageTask.class);
        	task.start();
        	new CountDownLatch(1).await();
		} catch (InterruptedException e) {
			LOGGER.error("项目启动异常", e);
		}
	}
}
