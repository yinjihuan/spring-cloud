package com.fangjia.fsh.substitution.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author yinjihuan
 * @create 2017-12-20 22:23
 **/
@RibbonClient(name = "fsh-house", configuration = BeanConfiguration.class)
public class RibbonClientConfig {

}
