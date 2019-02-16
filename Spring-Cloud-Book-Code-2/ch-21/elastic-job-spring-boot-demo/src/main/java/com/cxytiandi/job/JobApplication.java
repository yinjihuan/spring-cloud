package com.cxytiandi.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.cxytiandi.elasticjob.annotation.EnableElasticJob;

/**
 * ElasticJob Spring Boot集成案例
 * 
 * @author yinjihuan
 * 
 * @about http://cxytiandi.com/about
 *
 */
@SpringBootApplication
@EnableElasticJob
//开启动态任务添加API
@ComponentScan(basePackages = {"com.cxytiandi"})
public class JobApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(JobApplication.class, args);
	}
	
}
