package com.fangjia.fsh.api.filter;

import com.fangjia.common.base.ResponseCode;
import com.fangjia.common.base.ResponseData;
import com.fangjia.common.util.JsonUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;

/**
 * 服务降级过滤器
 *
 * @author yinjihuan
 * @create 2017-11-14 10:06
 **/
public class DowngradeFilter extends ZuulFilter {

    public DowngradeFilter() {
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
        String uri = ctx.getRequest().getRequestURI();
        if (StringUtils.isNotBlank(uri)) {
            String[] uris = uri.split("/");
            if (uris.length > 1) {
                String serviceId = uris[1];
                if ("fsh-house".equals(serviceId)) {
                    ctx.setSendZuulResponse(false);
                    ResponseData data = ResponseData.fail("服务降级中", ResponseCode.DOWNGRADE.getCode());
                    ctx.setResponseBody(JsonUtils.toJson(data));
                    ctx.getResponse().setContentType("application/json; charset=utf-8");
                    return null;
                }
            }
        }
        return null;
    }
}
