package com.fangjia.fsh.api.config;

import com.fangjia.fsh.api.filter.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 过滤器配置
 *
 * @author yinjihuan
 * @create 2017-11-07 16:24
 **/
@Configuration
public class FilterConfig {

    @Bean
    public AuthHeaderFilter preRequestLogFilter() {
        return new AuthHeaderFilter();
    }

    @Bean
    public LimitFilter limitFilter() {
        return new LimitFilter();
    }

    @Bean
    public DownGradeFilter downgradeFilter() {
        return new DownGradeFilter();
    }

    @Bean
    public IpFilter ipFilter() {
        return new IpFilter();
    }

    @Bean
    public GrayPushFilter grayPushFilter() {
        return new GrayPushFilter();
    }

    @Bean
    public AuthFilter authFilter() {
        return new AuthFilter();
    }

    @Bean
    public DebugRequest debugRequest() {
        return new DebugRequest();
    }
    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
}
