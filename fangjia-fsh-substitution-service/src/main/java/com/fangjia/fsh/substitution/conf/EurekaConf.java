package com.fangjia.fsh.substitution.conf;

import org.cxytiandi.conf.client.annotation.ConfField;
import org.cxytiandi.conf.client.annotation.CxytianDiConf;

/**
 * Eureka配置信息 (多个系统共用)
 *
 * @author yinjihuan
 * @create 2017-11-21 15:22
 **/
@CxytianDiConf(system = "fangjia-common", env = true, prefix = "eureka")
public class EurekaConf {
    @ConfField("Eureka注册中心地址")
    private String defaultZone = "http://yinjihuan:123456@master:8761/eureka/";

    public String getDefaultZone() {
        return defaultZone;
    }

    public void setDefaultZone(String defaultZone) {
        this.defaultZone = defaultZone;
    }
}
