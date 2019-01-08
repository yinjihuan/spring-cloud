package com.fangjia.sjdbc.po;

import java.io.Serializable;
import com.cxytiandi.jdbc.annotation.AutoId;
import com.cxytiandi.jdbc.annotation.Field;
import com.cxytiandi.jdbc.annotation.TableName;

@TableName(value = "user", author = "yinjihuan", desc = "用户表")
public class User implements Serializable {

	private static final long serialVersionUID = -1205226416664488559L;
	
	@AutoId
	@Field(value="id", desc="ID")
	private Long id;

	@Field(value="city", desc="城市")
	private String city = "";
	
	@Field(value="name", desc="姓名")
	private String name = "";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
