package com.cxytiandi.cache_data_redis.service;

public interface Closure<O, I> {
	public O execute(I input);
}