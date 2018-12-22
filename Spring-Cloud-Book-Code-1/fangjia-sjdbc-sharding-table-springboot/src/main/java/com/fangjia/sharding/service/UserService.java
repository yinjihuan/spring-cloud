package com.fangjia.sharding.service;

import java.util.List;
import com.fangjia.sharding.po.User;

public interface UserService {

	List<User> list();
	
	Long add(User user);
	
	User findById(Long id);
	
	User findByName(String name);
	
}
