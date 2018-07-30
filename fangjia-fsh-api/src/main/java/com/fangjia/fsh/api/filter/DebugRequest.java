package com.fangjia.fsh.api.filter;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.ribbon.RibbonHttpResponse;
import org.springframework.util.StreamUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * @author yinjihuan
 * @create 2017-12-30 19:50
 **/
public class DebugRequest extends ZuulFilter {
    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        HttpServletRequest req = (HttpServletRequest)RequestContext.getCurrentContext().getRequest();
        System.err.println("REQUEST:: " + req.getScheme() + " " + req.getRemoteAddr() + ":" + req.getRemotePort());
        System.err.println("REQUEST:: " + req.getScheme() + " " + req.getRemoteAddr() + ":" + req.getRemotePort());
        StringBuilder params = new StringBuilder("?");
        Enumeration<String> names = req.getParameterNames();
        if( req.getMethod().equals("GET") ) {
    	   while (names.hasMoreElements()) {
	   		  String name = (String) names.nextElement();
	   		  params.append(name);
	   		  params.append("=");
	   		  params.append(req.getParameter(name));
	   		  params.append("&");
   		   }
        }
       
        if (params.length() > 0) {
        	params.delete(params.length()-1, params.length());
        }
        System.err.println("REQUEST:: > " + req.getMethod() + " " + req.getRequestURI() + params + " " + req.getProtocol());

        Enumeration<String> headers = req.getHeaderNames();

        while (headers.hasMoreElements()) {
            String name = (String) headers.nextElement();
            String value = req.getHeader(name);
            System.err.println("REQUEST:: > " + name + ":" + value);
        }

        final RequestContext ctx = RequestContext.getCurrentContext();
        if (!ctx.isChunkedRequestBody()) {
            ServletInputStream inp = null;
            try {
                inp = ctx.getRequest().getInputStream();
                String body = null;
                if (inp != null) {
                	body = IOUtils.toString(inp);
                	System.err.println("REQUEST:: > " + body);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        // 第一种，获取响应结果
        try {
        	Object zuulResponse = RequestContext.getCurrentContext().get("zuulResponse");
        	if (zuulResponse != null) {
        		RibbonHttpResponse resp = (RibbonHttpResponse) zuulResponse;
    			String body = IOUtils.toString(resp.getBody());
    			System.err.println(body);
    			resp.close();
    			RequestContext.getCurrentContext().setResponseBody(body);
        	}
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        // 第二种，获取响应结果
       /* InputStream stream = RequestContext.getCurrentContext().getResponseDataStream();
		try {
			String body = IOUtils.toString(stream);
			System.err.println(body);
			RequestContext.getCurrentContext().setResponseBody(body);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
        return null;
    }

}