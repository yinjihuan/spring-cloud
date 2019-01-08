package com.cxytiandi.ribbon_eureka_demo.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * 为某个客户端指定配置
 * @author yinjihuan
 *
 */
@RibbonClient(name = "ribbon-config-demo", configuration = BeanConfiguration.class) 
public class RibbonClientConfig {  

}
