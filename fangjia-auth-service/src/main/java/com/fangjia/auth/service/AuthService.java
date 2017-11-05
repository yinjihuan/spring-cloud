package com.fangjia.auth.service;

import com.fangjia.auth.po.User;
import com.fangjia.auth.query.AuthQuery;

public interface AuthService {

	User auth(AuthQuery query);
	
}
