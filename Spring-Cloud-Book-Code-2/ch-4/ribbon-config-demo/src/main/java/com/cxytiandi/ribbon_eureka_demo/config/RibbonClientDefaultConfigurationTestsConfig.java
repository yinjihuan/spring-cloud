package com.cxytiandi.ribbon_eureka_demo.config;

import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * 默认配置
 * @author yinjihuan
 *
 */
@RibbonClients(defaultConfiguration = DefaultRibbonConfig.class)
public class RibbonClientDefaultConfigurationTestsConfig {

  
}