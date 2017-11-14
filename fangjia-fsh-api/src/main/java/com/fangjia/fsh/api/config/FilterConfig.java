package com.fangjia.fsh.api.config;

import com.fangjia.fsh.api.filter.AuthHeaderFilter;
import com.fangjia.fsh.api.filter.DowngradeFilter;
import com.fangjia.fsh.api.filter.LimitFilter;
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
    public DowngradeFilter downgradeFilter() {
        return new DowngradeFilter();
    }
}
