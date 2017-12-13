package com.fangjia.common.aspect;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import com.fangjia.common.anno.ApiRateLimit;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;


/**
 * 具体API并发控制
 * @author yinjihuan
 *
 */
@Aspect
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class ApiLimitAspect {

	public static Map<String, Semaphore> semaphoreMap = new ConcurrentHashMap<String, Semaphore>();

	@Around("execution(* com.fangjia.*.*.controller.*.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) {
		Object result = null;
		Semaphore semap = null;
		Class<?> clazz = joinPoint.getTarget().getClass();
		Map<String, String> map = isRateLimit(clazz, joinPoint.getSignature().getName(), joinPoint.getArgs());
		String key = map.get("key");
		if (key != null) {
			semap = semaphoreMap.get(key);
		} else {
			semap = semaphoreMap.get("open.api.defaultLimit");
		}
		try {
			semap.acquire();
			result = joinPoint.proceed();
		} catch (Throwable e) {
			throw new RuntimeException(e);
		} finally {
			semap.release();
		}
		return result;
	}
	
	private Map<String, String> isRateLimit(Class<?> clazz, String methodName, Object[] args) {
		Map<String, String> map = new HashMap<String, String>();
		for (Method method : clazz.getDeclaredMethods()) {
			if(method.getName().equals(methodName)){
				if (method.isAnnotationPresent(ApiRateLimit.class)) {
					String key = method.getAnnotation(ApiRateLimit.class).confKey();
					map.put("key", key);
					break;
				}
			}
		}
		return map;
	}


}
