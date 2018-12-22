package com.fangjia.job;

import java.util.concurrent.CountDownLatch;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = { "classpath:applicationContext.xml" })
public class JobApplication {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder().sources(JobApplication.class).web(false).run(args);
		try {
			new CountDownLatch(1).await();
		} catch (InterruptedException e) {
		}
	}

}
