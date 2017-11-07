package com.fangjia.api.client.auth;

import com.fangjia.api.client.auth.query.AuthQuery;
import com.fangjia.common.base.ResponseData;

/**
 * @author yinjihuan
 * @create 2017-11-07 19:01
 **/
public class AuthRemoteClientHystrix implements AuthRemoteClient {

    @Override
    public ResponseData auth(AuthQuery query) {
        return ResponseData.ok("");
    }
}
