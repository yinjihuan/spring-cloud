package com.fangjia.auth.service;

import org.springframework.stereotype.Service;
import com.fangjia.auth.po.User;
import com.fangjia.auth.query.AuthQuery;

@Service
public class AuthServiceImpl implements AuthService {

	@Override
	public User auth(AuthQuery query) {
		return new User(1L);
	}

}
