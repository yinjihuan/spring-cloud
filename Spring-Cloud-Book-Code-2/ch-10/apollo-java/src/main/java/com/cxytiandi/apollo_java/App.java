package com.cxytiandi.apollo_java;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;

/**
 * Apollo整合Java项目示列
 * 
 * @author yinjihuan
 * 
 * @about http://cxytiandi.com/about
 * 
 * @date 2018-12-16
 * 
 */
public class App {
	public static void main(String[] args) {
		// 指定环境（开发演示用，不能用于生产环境））
		System.setProperty("env", "DEV");
		Config config = ConfigService.getAppConfig(); 
		//getValue(config);
		addChangeListener(config);
		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void addChangeListener(Config config) {
		config.addChangeListener(new ConfigChangeListener() {
		    public void onChange(ConfigChangeEvent changeEvent) {
		        System.out.println("发生修改数据的命名空间是：" + changeEvent.getNamespace());
		        for (String key : changeEvent.changedKeys()) {
		            ConfigChange change = changeEvent.getChange(key);
		            System.out.println(String.format("发现修改 - 配置key: %s, 原来的值: %s, 修改后的值: %s, 操作类型: %s", change.getPropertyName(), change.getOldValue(), change.getNewValue(), change.getChangeType()));
		        }
		    }
		});
	}
	
	private static void getValue(Config config) {
		String key = "username";
		String defaultValue = "尹吉欢";
		String username = config.getProperty(key, defaultValue);
		System.out.println("username=" + username);
	}
}
