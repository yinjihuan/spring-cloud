package com.fangjia.sjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 分库又分表示列
 * @author  yinjihuan
 *
 */
@SpringBootApplication
@ImportResource(locations = { "classpath:sharding.xml" })
public class ShardingDbAndTableApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShardingDbAndTableApplication.class, args);
	}
}
