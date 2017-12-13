package com.fangjia.fsh.house.conf;

import java.util.concurrent.Semaphore;

import com.fangjia.common.aspect.ApiLimitAspect;
import org.cxytiandi.conf.client.annotation.ConfField;
import org.cxytiandi.conf.client.annotation.CxytianDiConf;
import org.cxytiandi.conf.client.core.SmconfUpdateCallBack;
import org.cxytiandi.conf.client.core.rest.Conf;


/**
 * 接口限流配置
 * @author yinjihuan
 *
 */
@CxytianDiConf(system = "fangjia-fsh-house-service", env = true, prefix = "open.api")
public class RestAPIRateLimitConf implements SmconfUpdateCallBack {
	@ConfField("默认的接口并发限制")
	private int defaultLimit = 10;

	@ConfField("房产信息接口")
	private int hosueInfo = 1;

	public void setHosueInfo(int hosueInfo) {
		this.hosueInfo = hosueInfo;
	}

	public int getHosueInfo() {
		return hosueInfo;
	}

	public int getDefaultLimit() {
		return defaultLimit;
	}

	public void setDefaultLimit(int defaultLimit) {
		this.defaultLimit = defaultLimit;
	}

	@Override
	public void reload(Conf conf) {
		ApiLimitAspect.semaphoreMap.put("open.api." + conf.getKey(), new Semaphore(Integer.parseInt(conf.getValue().toString())));
	}

}