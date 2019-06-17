package com.cxytiandi.cache_data_redis.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cxytiandi.cache_data_redis.po.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Cacheable(value = "get", key = "#id")
	public Person get(String id) {
		Person p = new Person();
		p.setFirstname("xxx");
		p.setLastname("bbb");
		p.setId("111");
		return p;
	}
	
}
