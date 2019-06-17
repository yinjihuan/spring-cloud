package com.cxytiandi.cache_guava;

public class PersonDao {

	Person findById(String id) {
		System.err.println("query id:" + id);
		Person p = new Person();
		p.setName("yinjihuan");
		return p;
	}
}
