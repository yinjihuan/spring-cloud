package com.fangjia.fsh.api.conf;

import com.fangjia.fsh.api.filter.LimitFilter;
import com.google.common.util.concurrent.RateLimiter;
import org.cxytiandi.conf.client.annotation.ConfField;
import org.cxytiandi.conf.client.annotation.CxytianDiConf;
import org.cxytiandi.conf.client.core.SmconfUpdateCallBack;
import org.cxytiandi.conf.client.core.rest.Conf;

/**
 * 限流配置
 *
 * @author yinjihuan
 * @create 2017-12-07 16:48
 **/
@CxytianDiConf(system = "fangjia-fsh-api", prefix = "api", env = true)
public class RateLimiterConf implements SmconfUpdateCallBack {
    @ConfField("总体限流速率")
    private double limitRate = 10;

    @ConfField("集群每秒限流速率")
    private int clusterLimitRate = 10;

    public void setClusterLimitRate(int clusterLimitRate) {
        this.clusterLimitRate = clusterLimitRate;
    }

    public int getClusterLimitRate() {
        return clusterLimitRate;
    }

    public void setLimitRate(double limitRate) {
        this.limitRate = limitRate;
    }

    public double getLimitRate() {
        return limitRate;
    }

    @Override
    public void reload(Conf conf) {
        // 更新RateLimiter
        LimitFilter.rateLimiter = RateLimiter.create(this.limitRate);
    }
}
