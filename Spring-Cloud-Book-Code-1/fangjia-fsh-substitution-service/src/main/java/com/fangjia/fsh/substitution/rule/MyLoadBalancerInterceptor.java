package com.fangjia.fsh.substitution.rule;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.Assert;

import java.io.IOException;
import java.net.URI;

/**
 * 自定义请求拦截器
 *
 * @author yinjihuan
 * @create 2017-12-21 14:25
 **/
public class MyLoadBalancerInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(final HttpRequest request, final byte[] body,
                                        final ClientHttpRequestExecution execution) throws IOException {
        final URI originalUri = request.getURI();
        String serviceName = originalUri.getHost();
        System.out.println("进入自定义的请求拦截器中"+serviceName);
        return execution.execute(request, body);
    }
}
