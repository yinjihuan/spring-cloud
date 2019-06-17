package com.fangjia.sjdbc.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fangjia.sjdbc.po.User;

@Mapper
public interface UserRepository {
	
	Long addUser(User user);
	
	List<User> list();
	
}
