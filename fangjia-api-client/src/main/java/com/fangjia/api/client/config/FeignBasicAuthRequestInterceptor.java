package com.fangjia.api.client.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * Feign请求拦截器
 * @author yinjihuan
 * @create 2017-11-10 17:25
 **/
public class FeignBasicAuthRequestInterceptor  implements RequestInterceptor {

    public FeignBasicAuthRequestInterceptor() {

    }

    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", System.getProperty("fangjia.auth.token"));
    }
}
