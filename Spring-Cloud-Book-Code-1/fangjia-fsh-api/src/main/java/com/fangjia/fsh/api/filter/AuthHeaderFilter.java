package com.fangjia.fsh.api.filter;

import com.fangjia.fsh.api.task.TokenScheduledTask;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 调用服务前添加认证请求头过滤器
 *
 * @author yinjihuan
 * @create 2017-11-07 16:06
 **/
public class AuthHeaderFilter extends ZuulFilter {

    public AuthHeaderFilter() {
        super();
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        Object success = ctx.get("isSuccess");
        return success == null ? true : Boolean.parseBoolean(success.toString());
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 5;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.addZuulRequestHeader("Authorization", System.getProperty("fangjia.auth.token"));
        return null;
    }
}
