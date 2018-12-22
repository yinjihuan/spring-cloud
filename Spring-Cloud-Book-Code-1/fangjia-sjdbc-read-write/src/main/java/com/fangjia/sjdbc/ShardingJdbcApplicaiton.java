package com.fangjia.sjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 读写分离示列
 * @author yinjihuan
 *
 */
@SpringBootApplication
@ImportResource(locations = { "classpath:sharding.xml" })
public class ShardingJdbcApplicaiton {
	public static void main(String[] args) {
		SpringApplication.run(ShardingJdbcApplicaiton.class, args);
	}
}
