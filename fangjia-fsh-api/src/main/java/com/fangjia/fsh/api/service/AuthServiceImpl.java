package com.fangjia.fsh.api.service;

import com.fangjia.api.client.auth.AuthRemoteClient;
import com.fangjia.api.client.auth.query.AuthQuery;
import com.fangjia.common.base.ResponseData;
import com.fangjia.common.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthRemoteClient authRemoteClient;

    @Override
    public String getToken() {
        AuthQuery query = new AuthQuery();
        query.setAccessKey("1");
        query.setSecretKey("1");
        ResponseData response = authRemoteClient.auth(query);
        return response.getData() == null ? "" : response.getData().toString();
    }
}
