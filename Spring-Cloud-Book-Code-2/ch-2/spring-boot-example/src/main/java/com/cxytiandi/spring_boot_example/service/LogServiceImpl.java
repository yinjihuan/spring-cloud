package com.cxytiandi.spring_boot_example.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

	@Async
	public void saveLog() {
		System.out.println(Thread.currentThread().getName());
	}

}
