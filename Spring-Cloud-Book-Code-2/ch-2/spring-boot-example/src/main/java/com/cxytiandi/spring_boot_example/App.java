package com.cxytiandi.spring_boot_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.cxytiandi.spring_boot_example.base.StartCommand;

@EnableAsync
@SpringBootApplication
public class App {
	public static void main(String[] args) {
		//new StartCommand(args);
		SpringApplication.run(App.class, args);
	}
}
