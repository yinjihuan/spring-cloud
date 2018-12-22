package com.fangjia.fsh.api.filter;

import com.fangjia.common.base.ResponseCode;
import com.fangjia.common.base.ResponseData;
import com.fangjia.common.util.IpUtils;
import com.fangjia.common.util.JsonUtils;
import com.fangjia.fsh.api.conf.BasicConf;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * IP黑名单限制过滤器
 *
 * @author yinjihuan
 * @create 2017-11-15 18:14
 **/
public class IpFilter extends ZuulFilter {

    @Autowired
    private BasicConf basicConf;

    public IpFilter() {
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
        return 1;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String ip = IpUtils.getIpAddr(ctx.getRequest());
        // 在黑名单中禁用
        if (StringUtils.isNotBlank(ip) && basicConf != null && basicConf.getIpStr().contains(ip)) {
            ctx.set("isSuccess", false);
            ctx.setSendZuulResponse(false);
            ResponseData data = ResponseData.fail("非法请求", ResponseCode.NO_AUTH_CODE.getCode());
            ctx.setResponseBody(JsonUtils.toJson(data));
            ctx.getResponse().setContentType("application/json; charset=utf-8");
            return null;
        }
        return null;
    }
}
