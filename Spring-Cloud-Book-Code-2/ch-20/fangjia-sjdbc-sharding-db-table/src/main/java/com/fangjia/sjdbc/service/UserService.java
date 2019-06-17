package com.fangjia.sjdbc.service;

import java.util.List;

import com.fangjia.sjdbc.po.User;

public interface UserService {

	List<User> list();
	
	Long add(User user);
	
	User findById(Long id);
	
	User findByName(String name);
	
}
