package com.cxytiandi.apollo_springboot.spring.annotation;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import com.cxytiandi.apollo_springboot.spring.annotation.property.PlaceholderHelper;
import com.cxytiandi.apollo_springboot.spring.annotation.property.SpringValue;
import com.cxytiandi.apollo_springboot.spring.annotation.property.SpringValueRegistry;

@Component
public class SpringValueProcessor implements BeanPostProcessor, BeanFactoryAware {
	
	private PlaceholderHelper placeholderHelper = new PlaceholderHelper() ;
	 
	private BeanFactory beanFactory;
	
	public SpringValueRegistry springValueRegistry = new SpringValueRegistry();
	 
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		Class clazz = bean.getClass();
		for (Field field : findAllField(clazz)) {
			processField(bean, beanName, field);
		}
		return bean;
	}

	private void processField(Object bean, String beanName, Field field) {
		// register @Value on field
		Value value = field.getAnnotation(Value.class);
		if (value == null) {
			return;
		}
		Set<String> keys = placeholderHelper.extractPlaceholderKeys(value.value());

		if (keys.isEmpty()) {
			return;
		}

		for (String key : keys) {
			SpringValue springValue = new SpringValue(key, value.value(), bean, beanName, field, false);
			springValueRegistry.register(beanFactory, key, springValue);
		}
	}

	private List<Field> findAllField(Class clazz) {
		final List<Field> res = new LinkedList<>();
		ReflectionUtils.doWithFields(clazz, new ReflectionUtils.FieldCallback() {
			@Override
			public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
				res.add(field);
			}
		});
		return res;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}
}
