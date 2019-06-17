package com.cxytiandi.cache_data_redis.controller;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxytiandi.cache_data_redis.po.Person;
import com.cxytiandi.cache_data_redis.repository.PersonRepository;
import com.cxytiandi.cache_data_redis.service.CacheService;
import com.cxytiandi.cache_data_redis.service.Closure;
import com.cxytiandi.cache_data_redis.service.PersonService;

@RestController
public class CacheController {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	PersonRepository repo;

	@Autowired
	private PersonService personService;

	@Autowired
	private CacheService cacheService;

	@Autowired
	private RedissonClient redissonClient;
	
	@GetMapping("/lock")
	public String lock() {
		RLock lock = redissonClient.getLock("anyLock");
		lock.lock(10, TimeUnit.SECONDS);
		System.out.println("-----");
		lock.unlock();
		return "success";
	}
	
	@GetMapping("/test2")
	public void basicCrudOperations() {
		Person person = new Person();
		person.setFirstname(" 尹吉欢 ");
		person.setLastname("yinjihuan");
		repo.save(person);
		Optional<Person> personObj = repo.findById(person.getId());
		System.err.println(personObj.get().getFirstname());
		System.err.println(repo.count());
		repo.delete(person);
	}

	@GetMapping("/test")
	public String test() {
		stringRedisTemplate.opsForValue().set("key", " 猿天地 ", 1, TimeUnit.HOURS);
		String value = stringRedisTemplate.opsForValue().get("key");
		System.out.println(value);
		stringRedisTemplate.delete("key");
		boolean exists = stringRedisTemplate.hasKey("key");
		System.out.println(exists);
		RedisConnection connection = stringRedisTemplate.getConnectionFactory().getConnection();
		connection.set("name".getBytes(), "yinjihuan".getBytes());
		System.out.println(new String(connection.get("name".getBytes())));
		return "success";
	}

	@GetMapping("/get")
	public Person get() {
		return personService.get("1001");
	}

	@GetMapping("/getCallback")
	public String getCallback() {
		String cacheKey = "1001";
		return cacheService.getCache(cacheKey, new Closure<String, String>() {
			@Override
			public String execute(String id) {
				// 执行你的业务逻辑
				return id+"hello";
			}
		});
	}
}
