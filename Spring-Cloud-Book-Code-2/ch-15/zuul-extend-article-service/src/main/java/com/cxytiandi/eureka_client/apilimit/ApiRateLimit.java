package com.cxytiandi.eureka_client.apilimit;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 对 API 进行访问速度限制 <br>
 * 限制的速度值在 Apollo 配置中通过 key 关联
 * 
 * @author yinjihuan
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiRateLimit {
	/**
	 * Apollo 配置中的 key
	 * 
	 * @return
	 * 
	 */
	String confKey();
}