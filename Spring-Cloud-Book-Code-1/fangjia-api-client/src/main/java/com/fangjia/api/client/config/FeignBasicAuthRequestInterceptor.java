package com.fangjia.api.client.config;

import com.fangjia.common.filter.HttpHeaderParamFilter;
import com.fangjia.common.support.RibbonFilterContextHolder;
import feign.RequestInterceptor;
import feign.RequestTemplate;

import java.util.Map;

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
        Map<String, String> attributes = RibbonFilterContextHolder.getCurrentContext().getAttributes();
        for (String key :  attributes.keySet()) {
            String value = attributes.get(key);
            System.out.println("feign :" + key + "\t" + value);
            template.header(key, value);
        }
    }
}
