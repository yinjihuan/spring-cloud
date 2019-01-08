package com.cxytiandi.zuul_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalController {

	@GetMapping("/local/{id}")
	public String local(@PathVariable String id) {
		return id;
	}

}
