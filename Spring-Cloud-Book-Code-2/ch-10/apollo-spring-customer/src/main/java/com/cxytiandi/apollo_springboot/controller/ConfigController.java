package com.cxytiandi.apollo_springboot.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxytiandi.apollo_springboot.spring.annotation.SpringValueProcessor;
import com.cxytiandi.apollo_springboot.spring.annotation.property.SpringValue;

@RestController
public class ConfigController {

	@Value("${cxytiandiName:yinjihuan}")
	private String name;

	@Value("${cxytiandiUrl}")
	private String cxytiandiUrl;

	@Autowired
	private SpringValueProcessor springValueProcessor;

	@Autowired
	private ConfigurableBeanFactory beanFactory;

	@GetMapping("/get")
	public String get() {
		return name + cxytiandiUrl;
	}

	@GetMapping("/update")
	public String update(String value) {
		Collection<SpringValue> targetValues = springValueProcessor.springValueRegistry.get(beanFactory,
				"cxytiandiName");
		for (SpringValue val : targetValues) {
			try {
				val.update(value);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return name;
	}

	
}
