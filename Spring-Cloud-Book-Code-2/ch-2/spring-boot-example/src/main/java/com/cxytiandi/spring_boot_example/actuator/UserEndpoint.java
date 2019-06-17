package com.cxytiandi.spring_boot_example.actuator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;


@Component
@Endpoint(id = "user")
public class UserEndpoint {

	@ReadOperation
	public List<Map<String, Object>> health() {
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("userId", 1001);
		map.put("userName", "yinjihuan");
		list.add(map);
		return list;
	}

}
