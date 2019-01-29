package com.cxytiandi.cache_data_redis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cxytiandi.cache_data_redis.po.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, String> {

}