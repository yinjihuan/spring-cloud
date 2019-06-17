package com.cxytiandi.mysql.po;

import java.io.Serializable;

import com.cxytiandi.jdbc.Orders;
import com.cxytiandi.jdbc.annotation.Field;
import com.cxytiandi.jdbc.annotation.TableName;

import lombok.Data;

@Data
@TableName(value = "loudong", desc = " 楼栋表 ", author = "yinjihuan")
public class LouDong implements Serializable {
	
	private static final long serialVersionUID = -6690784263770712827L;

	@Field(value = "id", desc = " 主键 ID")
	private String id;

	@Field(value = "name", desc = " 小区名称 ")
	private String name;

	@Field(value = "city", desc = " 城市 ")
	private String city;

	@Field(value = "region", desc = " 区域 ")
	private String region;

	@Field(value = "ld_num", desc = " 楼栋号 ")
	private String ldNum;

	@Field(value = "unit_num", desc = " 单元号 ")
	private String unitNum;

	public final static String[] SHOW_FIELDS =
			new String[]{ "city", "region", "name", "ld_num" };

	public final static String[] QUERRY_FIELDS =
			new String[]{ "city", "region", "name" };

	public final static Orders[] ORDER_FIELDS =
			new Orders[] { new Orders("id", Orders.OrderyType.ASC) };

}
