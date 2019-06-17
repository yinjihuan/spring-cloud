package com.fangjia.api.client.auth;

import com.fangjia.api.client.auth.query.AuthQuery;
import com.fangjia.api.client.config.FeignConfiguration;
import com.fangjia.common.base.ResponseData;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 房生活认证服务API调用客户端
 *
 * @author yinjihuan
 * @create 2017-11-07 13:55
 **/
@FeignClient(value = "fangjia-auth-service", path = "/oauth", configuration = FeignConfiguration.class, fallback = AuthRemoteClientHystrix.class)
public interface AuthRemoteClient {

    /**
     * 调用认证,获取token
     * @param query
     * @return
     */
    @PostMapping("/token")
    ResponseData auth(@RequestBody AuthQuery query);

}
