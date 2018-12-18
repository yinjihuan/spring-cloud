package com.cxytiandi.spring_boot_example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.task.pool")
public class TaskThreadPoolConfig {
	
	//核心线程数     
	private int corePoolSize = 5;

	//最大线程数     
	private int maxPoolSize = 50;

	//线程池维护线程所允许的空闲时间     
	private int keepAliveSeconds = 60;

	//队列长度     
	private int queueCapacity = 10000;

	//线程名称前缀     
	private String threadNamePrefix = "FSH-AsyncTask-";
	
}
