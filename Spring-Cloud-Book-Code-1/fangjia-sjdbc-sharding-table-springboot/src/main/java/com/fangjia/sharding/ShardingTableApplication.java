package com.fangjia.sharding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 不分库，只分表案例
 * @author yinjihuan
 */
@SpringBootApplication
public class ShardingTableApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShardingTableApplication.class, args);
	}
}
