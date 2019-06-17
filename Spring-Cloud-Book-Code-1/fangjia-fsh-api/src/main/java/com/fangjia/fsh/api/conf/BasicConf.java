package com.fangjia.fsh.api.conf;

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

    @ConfField("降级的服务ID，多个用逗号分隔")
    private String downGradeServiceStr = "default";

    @ConfField("灰度发布的服务信息，ip:port，多个用逗号分隔")
    private String grayPushServers = "default";

    @ConfField("灰度发布的用户ID信息，多个用逗号分隔")
    private String grayPushUsers = "default";

    @ConfField("API接口白名单，多个用逗号分隔")
    private String apiWhiteStr = "default";

    public String getApiWhiteStr() {
        return apiWhiteStr;
    }

    public void setApiWhiteStr(String apiWhiteStr) {
        this.apiWhiteStr = apiWhiteStr;
    }

    public String getGrayPushServers() {
        return grayPushServers;
    }

    public void setGrayPushServers(String grayPushServers) {
        this.grayPushServers = grayPushServers;
    }

    public String getGrayPushUsers() {
        return grayPushUsers;
    }

    public void setGrayPushUsers(String grayPushUsers) {
        this.grayPushUsers = grayPushUsers;
    }

    public String getDownGradeServiceStr() {
        return downGradeServiceStr;
    }

    public void setDownGradeServiceStr(String downGradeServiceStr) {
        this.downGradeServiceStr = downGradeServiceStr;
    }

    public String getIpStr() {
        return ipStr;
    }

    public void setIpStr(String ipStr) {
        this.ipStr = ipStr;
    }

}
