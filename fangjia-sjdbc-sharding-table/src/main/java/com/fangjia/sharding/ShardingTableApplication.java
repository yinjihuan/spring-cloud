package com.fangjia.sharding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 不分库，之分表案例
 *
 */
@SpringBootApplication
@ImportResource(locations = { "classpath:sharding.xml" })
public class ShardingTableApplication {
	public static void main(String[] args) {
		System.out.println(1002%4);
		//SpringApplication.run(ShardingTableApplication.class, args);
	}
}
