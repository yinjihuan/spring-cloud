package com.fangjia.common.listenter;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.Semaphore;
import com.fangjia.common.anno.ApiRateLimit;
import com.fangjia.common.aspect.ApiLimitAspect;
import com.fangjia.common.util.ClasspathPackageScannerUtils;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.web.bind.annotation.RestController;

/**
 * 初始化需要进行并发限制的API
 * @author yinjihuan
 *
 */
public class InitApiLimitRateListener implements ApplicationListener<ApplicationPreparedEvent> {

	// Controller包路径
	private String controllerPath;

	public InitApiLimitRateListener(String controllerPath) {
		this.controllerPath = controllerPath;
	}

	@Override
	public void onApplicationEvent(ApplicationPreparedEvent arg0) {
		try {
			initLimitRateAPI();
		} catch (Exception e) {
			throw new RuntimeException("初始化需要进行并发限制的API异常", e);
		}
	}
	
	/**
	 * 初始化需要进行并发限制的API
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void initLimitRateAPI() throws IOException, ClassNotFoundException {
		Object rate = System.getProperty("open.api.defaultLimit") == null ? 100 : System.getProperty("open.api.defaultLimit");
		ApiLimitAspect.semaphoreMap.put("open.api.defaultLimit", new Semaphore(Integer.parseInt(rate.toString())));
		ClasspathPackageScannerUtils scan = new ClasspathPackageScannerUtils(this.controllerPath);
		List<String> classList = scan.getFullyQualifiedClassNameList();
		for (String clazz : classList) {
			Class<?> clz = Class.forName(clazz);
			if (!clz.isAnnotationPresent(RestController.class)) {
				continue;
			}
			Method[] methods = clz.getDeclaredMethods();
			for (Method method : methods) {
				if (method.isAnnotationPresent(ApiRateLimit.class)) {
					String confKey = method.getAnnotation(ApiRateLimit.class).confKey();
					if (System.getProperty(confKey) != null) {
						int limit = Integer.parseInt(System.getProperty(confKey));
						ApiLimitAspect.semaphoreMap.put(confKey, new Semaphore(limit));
					}
				}
			}
		}
	}

}
