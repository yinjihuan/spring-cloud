package com.cxytiandi.mysql.service;

import java.util.List;

import com.cxytiandi.jdbc.PageQueryParam;
import com.cxytiandi.mysql.po.LouDong;

public interface LdService {
	
	public long count();

	public List<LouDong> findAll();

	public List<LouDong> find(String city);

	public List<LouDong> find(String city, String region);

	public List<LouDong> find(String city, String region, String name);

	public List<LouDong> findAll(PageQueryParam page);

	public boolean exists(String city);

	public List<LouDong> in(String[] names);

	public LouDong get(String id);
	
	public void delete(String name);

	public void save(LouDong louDong);

	public void saveList(List<LouDong> list);

	public void update(LouDong louDong);

	public void updateList(List<LouDong> list);
}
