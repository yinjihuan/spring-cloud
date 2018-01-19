package com.fangjia.fsh.user.config;

import com.cxytiandi.jdbc.CxytiandiJdbcTemplate;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置信息
 *
 * @author yinjihuan
 * @create 2017-11-20 18:10
 **/
@Configuration
public class BeanConfig {

    /**
     * JDBC
     * @return
     */
    @Bean(autowire= Autowire.BY_NAME)
    public CxytiandiJdbcTemplate cxytiandiJdbcTemplate() {
        return new CxytiandiJdbcTemplate("com.fangjia.fsh.user.po");
    }

}
