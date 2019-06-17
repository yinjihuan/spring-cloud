package com.fangjia.sjdbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cxytiandi.jdbc.EntityService;
import com.dangdang.ddframe.rdb.sharding.api.HintManager;
import com.fangjia.sjdbc.po.User;

@Service
public class UserServiceImpl extends EntityService<User> implements UserService {
	
	public List<User> list() {
		// 强制路由主库
		HintManager.getInstance().setMasterRouteOnly();
		return super.list();
	}

	public Long add(User user) {
		return (Long) super.save(user);
	}

}
