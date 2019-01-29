package com.cxytiandi.zuul_demo.filter;


import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;

import com.cxytiandi.zuul_demo.config.BasicConf;
import com.cxytiandi.zuul_demo.support.RibbonFilterContextHolder;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 灰度发布过滤器
 *
 * @author yinjihuan
 * @create 2017-11-16 10:06
 **/
public class GrayPushFilter extends ZuulFilter {
    @Autowired
    private BasicConf basicConf;

    public GrayPushFilter() {
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
        return "route";
    }

    @Override
    public int filterOrder() {
        return 6;
    }
    
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        // AuthFilter验证成功之后设置的用户编号
        String loginUserId = ctx.getZuulRequestHeaders().get("uid");
        RibbonFilterContextHolder.getCurrentContext().add("userId", loginUserId);
        // 灰度发布的服务信息
        RibbonFilterContextHolder.getCurrentContext().add("servers",basicConf.getGrayPushServers());
        // 灰度发布的用户ID信息
        RibbonFilterContextHolder.getCurrentContext().add("userIds", basicConf.getGrayPushUsers());
        return null;
    }
}
