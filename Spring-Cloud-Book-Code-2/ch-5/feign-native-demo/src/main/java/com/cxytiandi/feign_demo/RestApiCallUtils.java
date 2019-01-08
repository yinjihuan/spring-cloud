package com.cxytiandi.feign_demo;

import feign.Feign;

public class RestApiCallUtils {
	/**
	 * 获取 API 接口代理对象
	 * 
	 * @param apiType 接 口 类
	 * @param url     API 地址
	 * @return
	 */
	public static <T> T getRestClient(Class<T> apiType, String url) {
		return Feign.builder().target(apiType, url);
	}

}
