package com.cxytiandi.cache_data_redis.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Data;

@Data
@RedisHash("persons")
public class Person {
	@Id
	String id;
	String firstname;
	String lastname;
}
