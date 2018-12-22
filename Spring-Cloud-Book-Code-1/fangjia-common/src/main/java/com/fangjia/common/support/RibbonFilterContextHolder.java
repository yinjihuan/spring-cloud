package com.fangjia.common.support;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @author yinjihuan
 * @create 2017-11-16 13:51
 **/
public class RibbonFilterContextHolder {
    private static final TransmittableThreadLocal<RibbonFilterContext> contextHolder = new TransmittableThreadLocal<RibbonFilterContext>() {
        @Override
        protected RibbonFilterContext initialValue() {
            return new DefaultRibbonFilterContext();
        }
    };


    public static RibbonFilterContext getCurrentContext() {
        return contextHolder.get();
    }


    public static void clearCurrentContext() {
        contextHolder.remove();
    }
}
