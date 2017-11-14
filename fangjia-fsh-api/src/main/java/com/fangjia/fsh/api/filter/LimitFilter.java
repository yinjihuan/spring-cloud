package com.fangjia.fsh.api.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 总体限流过滤器
 *
 * @author yinjihuan
 * @create 2017-11-14 10:06
 **/
public class LimitFilter extends ZuulFilter {
    public static volatile RateLimiter rateLimiter = RateLimiter.create(100.0);

    public LimitFilter() {
        super();
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public Object run() {
        //总体限流
        rateLimiter.acquire();
        return null;
    }
}
