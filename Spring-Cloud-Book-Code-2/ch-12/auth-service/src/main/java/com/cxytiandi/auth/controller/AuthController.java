package com.cxytiandi.auth.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxytiandi.auth.common.ResponseData;
import com.cxytiandi.auth.po.User;
import com.cxytiandi.auth.query.AuthQuery;
import com.cxytiandi.auth.service.AuthService;
import com.cxytiandi.auth.util.JWTUtils;

@RestController
@RequestMapping(value="/oauth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/token")
	public ResponseData auth(@RequestBody AuthQuery query) throws Exception {
		if (StringUtils.isBlank(query.getAccessKey()) || StringUtils.isBlank(query.getSecretKey())) {
			return ResponseData.failByParam("accessKey and secretKey not null");
		}
		
		User user = authService.auth(query);
		if (user == null) {
			return ResponseData.failByParam("认证失败");
		}
		
		JWTUtils jwt = JWTUtils.getInstance();
		return ResponseData.ok(jwt.getToken(user.getId().toString()));
	}

	@GetMapping("/token")
	public ResponseData oauth(AuthQuery query) throws Exception {
		if (StringUtils.isBlank(query.getAccessKey()) || StringUtils.isBlank(query.getSecretKey())) {
			return ResponseData.failByParam("accessKey and secretKey not null");
		}

		User user = authService.auth(query);
		if (user == null) {
			return ResponseData.failByParam("认证失败");
		}

		JWTUtils jwt = JWTUtils.getInstance();
		return ResponseData.ok(jwt.getToken(user.getId().toString()));
	}
	
}
