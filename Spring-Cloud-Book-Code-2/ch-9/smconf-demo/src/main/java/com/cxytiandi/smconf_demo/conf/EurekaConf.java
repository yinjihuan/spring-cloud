package com.cxytiandi.smconf_demo.conf;

import org.cxytiandi.conf.client.annotation.ConfField;
import org.cxytiandi.conf.client.annotation.CxytianDiConf;
import org.cxytiandi.conf.client.core.SmconfUpdateCallBack;
import org.cxytiandi.conf.client.core.rest.Conf;

/**
 * Eureka 配置信息
 * 
 * @author yinjihuan
 *
 **/
@CxytianDiConf(system = "fangjia-common", env = true, prefix = "eureka")
public class EurekaConf implements SmconfUpdateCallBack {

	@ConfField("Eureka 注册中心地址 ")
	private String defaultZone = "http://yinjihuan:123456@localhost:8761/eureka/";

	public String getDefaultZone() {
		return defaultZone;
	}

	public void setDefaultZone(String defaultZone) {
		this.defaultZone = defaultZone;
	}

	@Override
	public void reload(Conf conf) {
		// 执行你的逻辑
		System.err.println(conf.getKey() + "更新了");
	}

}
