package com.cxytiandi.auth.service;

import com.cxytiandi.auth.po.User;
import com.cxytiandi.auth.query.AuthQuery;

public interface AuthService {

	User auth(AuthQuery query);
	
}
