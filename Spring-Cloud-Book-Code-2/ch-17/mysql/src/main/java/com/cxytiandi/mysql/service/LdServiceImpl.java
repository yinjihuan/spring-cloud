package com.cxytiandi.mysql.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxytiandi.jdbc.EntityService;
import com.cxytiandi.jdbc.PageQueryParam;
import com.cxytiandi.mysql.po.LouDong;

@Service
public class LdServiceImpl extends EntityService<LouDong> implements LdService {

	public long count() {
		return super.count();
	}

	public List<LouDong> findAll() {
		return super.list(LouDong.ORDER_FIELDS);
	}

	public List<LouDong> find(String city) {
		return super.list("city", city);
	}

	public List<LouDong> find(String city, String region) {
		return super.list(new String[] { "city", "region" }, new Object[] { city, region });
	}

	public List<LouDong> find(String city, String region, String name) {
		return super.list(LouDong.SHOW_FIELDS, LouDong.QUERRY_FIELDS, new Object[] { city, region, name });
	}

	public List<LouDong> findAll(PageQueryParam page) {
		return super.listForPage(page.getStart(), page.getLimit(), LouDong.ORDER_FIELDS);
	}

	public boolean exists(String city) {
		return super.exists("city", city);
	}

	public List<LouDong> in(String[] names) {
		return super.in(new String[] { "city", "region" }, "name", names);
	}

	public LouDong get(String id) {
		return super.getById("id", id);
	}

	@Transactional
	public void delete(String name) {
		super.deleteById("name", name);
	}

	public void save(LouDong louDong) {
		super.save(louDong);
	}

	public void saveList(List<LouDong> list) {
		super.batchSave(list);
	}

	public void update(LouDong louDong) {
		super.update(louDong, "id");
	}

	public void updateList(List<LouDong> list) {
		super.batchUpdateByContainsFields(list, "id", "city");
	}

}
