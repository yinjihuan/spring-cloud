package com.fangjia.sjdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangjia.sjdbc.po.User;
import com.fangjia.sjdbc.repository.UserRepository;

import io.shardingjdbc.core.api.HintManager;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> list() {
		// 强制路由主库
		HintManager.getInstance().setMasterRouteOnly();
		return userRepository.list();
	}

	public Long add(User user) {
		return userRepository.addUser(user);
	}

}
