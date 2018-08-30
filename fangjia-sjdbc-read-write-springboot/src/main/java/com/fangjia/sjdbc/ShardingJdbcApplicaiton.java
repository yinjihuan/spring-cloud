package com.fangjia.sjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot版 Sharding JDBC 读写分离示列
 * 
 * @author yinjihuan
 *
 * @about http://cxytiandi.com/about
 */
@SpringBootApplication
public class ShardingJdbcApplicaiton {
	public static void main(String[] args) {
		SpringApplication.run(ShardingJdbcApplicaiton.class, args);
	}
}
