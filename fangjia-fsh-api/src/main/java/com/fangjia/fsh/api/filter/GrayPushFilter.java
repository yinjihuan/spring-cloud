package com.fangjia.fsh.api.filter;

import com.fangjia.fsh.api.config.BasicConf;
import com.fangjia.fsh.api.support.RibbonFilterContextHolder;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

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
        RibbonFilterContextHolder.clearCurrentContext();
        RibbonFilterContextHolder.getCurrentContext().add("userId", "1002");
        RibbonFilterContextHolder.getCurrentContext().add("servers", basicConf.getGrayPushServers());
        RibbonFilterContextHolder.getCurrentContext().add("userIds", basicConf.getGrayPushUsers());
        return null;
    }
}
