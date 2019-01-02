package com.cxytiandi.feign_demo.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cxytiandi.feignapi.user.User;
import com.cxytiandi.feignapi.user.UserRemoteClient;

@RestController
public class DemoController implements UserRemoteClient {

	@Override
	public String getName() {
		return "yinjihuan";
	}

	@Override
	public String getUserInfo(@RequestParam("name")String name) {
		return name;
	}

	@Override
	public String getUserDetail(@RequestParam Map<String, Object> param) {
		System.err.println(param.toString());
		return param.get("name").toString();
	}

	@Override
	public String addUser(@RequestBody User user) {
		return user.getName();
	}

}
