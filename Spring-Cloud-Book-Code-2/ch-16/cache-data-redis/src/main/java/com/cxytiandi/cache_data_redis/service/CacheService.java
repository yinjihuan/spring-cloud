package com.cxytiandi.cache_data_redis.service;

import java.util.concurrent.TimeUnit;

public interface CacheService {
	/**
	 * 设置缓存
	 * 
	 * @param key      缓存 KEY
	 * @param value    缓存值
	 * @param timeout  缓存过期时间
	 * @param timeUnit 缓存过期时间单位
	 */
	public void setCache(String key, String value, long timeout, TimeUnit timeUnit);

	/**
	 * 获取缓存
	 * 
	 * @param key 缓 存 KEY
	 * @return
	 */
	public String getCache(String key);

	public <V, K> String getCache(K key, Closure<V, K> closure);

	public <V, K> String getCache(K key, Closure<V, K> closure, long timeout, TimeUnit timeUnit);

	/**
	 * 删除缓存
	 * 
	 * @param key 缓 存 KEY
	 */
	public void deleteCache(String key);
}