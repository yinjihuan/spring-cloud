package com.cxytiandi.gateway.conf;

import java.util.HashMap;
import java.util.Map;

import org.cxytiandi.conf.client.annotation.ConfField;
import org.cxytiandi.conf.client.annotation.CxytianDiConf;

@CxytianDiConf(system="fangjia-gateway")
public class RateLimitConf {
	// 限流配置
	@ConfField(value = "limitMap")
	private Map<String, Integer> limitMap = new HashMap<String, Integer>(){{
		put("default.replenishRate", 100);
		put("default.burstCapacity", 1000);
	}};
	public void setLimitMap(Map<String, Integer> limitMap) {
		this.limitMap = limitMap;
	}
	public Map<String, Integer> getLimitMap() {
		return limitMap;
	}
}
