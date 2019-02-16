package com.fangjia.sharding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 不分库，之分表案例
 * @author yinjihuan
 */
@SpringBootApplication
@ImportResource(locations = { "classpath:sharding.xml" })
public class ShardingTableApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShardingTableApplication.class, args);
	}
}
