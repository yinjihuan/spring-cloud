package com.fangjia.fsh.api.filter;

import com.fangjia.fsh.api.service.AuthService;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * 调用服务前添加认证请求头过滤器
 *
 * @author yinjihuan
 * @create 2017-11-07 16:06
 **/
public class AuthHeaderFilter extends ZuulFilter {
    @Autowired
    private AuthService authService;

    public AuthHeaderFilter() {
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
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        ctx.addZuulRequestHeader("Authorization", authService.getToken());
        System.out.println(authService+request.getRequestURI());
        return null;
    }
}
