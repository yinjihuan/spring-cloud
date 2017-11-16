package com.fangjia.fsh.api.config;

import org.cxytiandi.conf.client.annotation.ConfField;
import org.cxytiandi.conf.client.annotation.CxytianDiConf;

/**
 * 基础配置信息
 *
 * @author yinjihuan
 * @create 2017-11-15 17:06
 **/
@CxytianDiConf(system = "fangjia-fsh-api")
public class BasicConf {

    @ConfField("IP黑名单，多个用逗号分隔")
    private String ipStr = "default";

    public String getIpStr() {
        return ipStr;
    }

    public void setIpStr(String ipStr) {
        this.ipStr = ipStr;
    }

}
