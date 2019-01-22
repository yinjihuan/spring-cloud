package com.cxytiandi.auth.service;

import org.springframework.stereotype.Service;

import com.cxytiandi.auth.po.User;
import com.cxytiandi.auth.query.AuthQuery;

@Service
public class AuthServiceImpl implements AuthService {

	@Override
	public User auth(AuthQuery query) {
		return new User(1L);
	}

}
