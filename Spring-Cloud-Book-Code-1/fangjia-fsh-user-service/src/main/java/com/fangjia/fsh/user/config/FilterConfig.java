package com.fangjia.fsh.user.config;

import com.fangjia.common.filter.HttpBasicAuthorizeFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤器配置
 *
 * @author yinjihuan
 * @create 2017-11-07 14:05
 **/
@Configuration
public class FilterConfig {
   // @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        HttpBasicAuthorizeFilter httpBasicFilter = new HttpBasicAuthorizeFilter();
        registrationBean.setFilter(httpBasicFilter);
        List<String> urlPatterns = new ArrayList<String>(1);
        urlPatterns.add("/*");
        registrationBean.setUrlPatterns(urlPatterns);
        return registrationBean;
    }
}
