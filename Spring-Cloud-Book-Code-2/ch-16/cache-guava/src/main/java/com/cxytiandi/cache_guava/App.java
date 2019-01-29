package com.cxytiandi.cache_guava;

import java.util.concurrent.TimeUnit;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class App {
	public static void main(String[] args) {
		final PersonDao dao = new PersonDao();
		LoadingCache<String, Person> cahceBuilder = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.SECONDS)
				.build(new CacheLoader<String, Person>() {
					@Override
					public Person load(String key) throws Exception {
						return dao.findById(key);
					}
				});
		
		try {
			for(;;) {
				Person person = cahceBuilder.get("1");
				System.out.println(person.getName());
				Thread.sleep(200);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
