package com.fangjia.common.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 对API进行访问速度限制<br>
 * 限制的速度值在Smconf配置中通过key关联
 * @author yinjihuan
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiRateLimit {
	
	/**
	 * Smconf 配置中的key
	 * @return
	 */
	String confKey();
	
}
