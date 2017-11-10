package com.fangjia.api.client.auth;

import com.fangjia.api.client.auth.query.AuthQuery;
import com.fangjia.common.base.ResponseData;
import org.springframework.stereotype.Component;

/**
 * @author yinjihuan
 * @create 2017-11-07 19:01
 **/
@Component
public class AuthRemoteClientHystrix implements AuthRemoteClient {

    @Override
    public ResponseData auth(AuthQuery query) {
        return ResponseData.ok("");
    }
}
