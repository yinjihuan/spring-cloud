package com.cxytiandi.apollo_springboot.core;

import java.util.HashSet;
import java.util.Set;

public class Config {
	
	public String getProperty(String key, String defaultValue) {
		if (key.equals("cxytiandiName")) {
			return "猿天地";
		}
		return null;
	}

	public Set<String> getPropertyNames() {
		Set<String> names = new HashSet<>();
		names.add("cxytiandiName");
		return names;
	}
	
}
