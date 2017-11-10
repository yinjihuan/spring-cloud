package com.fangjia.api.client.fsh.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * Feign请求拦截器
 * @author yinjihuan
 * @create 2017-11-10 17:25
 **/
public class FeignBasicAuthRequestInterceptor  implements RequestInterceptor {
    private final String headerValue;

    public FeignBasicAuthRequestInterceptor(String headerValue) {
        this.headerValue = headerValue;
    }
    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", headerValue);
    }
}
