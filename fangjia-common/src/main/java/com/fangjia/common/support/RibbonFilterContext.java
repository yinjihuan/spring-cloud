package com.fangjia.common.support;

import java.util.Map;

/**
 * @author yinjihuan
 * @create 2017-11-16 13:54
 **/
public interface RibbonFilterContext {
    RibbonFilterContext add(String key, String value);

    String get(String key);

    RibbonFilterContext remove(String key);

    Map<String, String> getAttributes();
}
