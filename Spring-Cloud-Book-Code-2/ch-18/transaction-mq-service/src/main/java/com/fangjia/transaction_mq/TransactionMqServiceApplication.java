package com.fangjia.transaction_mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 消息队列实现最终一致性分布式事务解决方案
 * @author yinjihuan
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class TransactionMqServiceApplication {
	public static void main(String[] args) {
		 SpringApplication.run(TransactionMqServiceApplication.class, args);
	}
}
