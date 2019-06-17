package com.cxytiandi.eureka_client.feign;

import java.util.Map;

import com.cxytiandi.eureka_client.support.RibbonFilterContextHolder;

import feign.RequestInterceptor;
import feign.RequestTemplate;
/**
 * 传递用户信息到被调用的服务
 * 
 * @author yinjihuan
 *
 */
public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {
	public FeignBasicAuthRequestInterceptor() {

	}

	@Override
	public void apply(RequestTemplate template) {
		Map<String, String> attributes = RibbonFilterContextHolder.getCurrentContext().getAttributes();
		for (String key : attributes.keySet()) {
			String value = attributes.get(key);
			template.header(key, value);
		}
	}

}