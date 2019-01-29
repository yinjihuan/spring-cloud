package com.cxytiandi.zuul_demo.support;

import java.util.Map;

public interface RibbonFilterContext {
    RibbonFilterContext add(String key, String value);

    String get(String key);

    RibbonFilterContext remove(String key);

    Map<String, String> getAttributes();
}
