package com.cxytiandi.zuul_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cxytiandi.zuul_demo.filter.AuthFilter;
import com.cxytiandi.zuul_demo.filter.DownGradeFilter;
import com.cxytiandi.zuul_demo.filter.GrayPushFilter;
import com.cxytiandi.zuul_demo.filter.LimitFilter;

@Configuration
public class FilterConfig {

	@Bean
	public AuthFilter authFilter() {
		return new AuthFilter();
	}
	
	@Bean
	public LimitFilter limitFilter() {
		return new LimitFilter();
	}
	
	//@Bean
	public DownGradeFilter downGradeFilter() {
		return new DownGradeFilter();
	}
	@Bean
	public GrayPushFilter grayPushFilter() {
		return new GrayPushFilter();
	}
}
