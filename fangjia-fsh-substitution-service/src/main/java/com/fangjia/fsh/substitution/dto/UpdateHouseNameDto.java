package com.fangjia.fsh.substitution.dto;
/**
 * 小区名称修改数据传输信息
 * @author yinjihuan
 *
 */
public class UpdateHouseNameDto {
	// 城市
	private String city;
	// 区域
	private String region;
	// 小区名称
	private String name;
	// 新的小区名称
	private String newName;
	
	public UpdateHouseNameDto(String city, String region, String name, String newName) {
		super();
		this.city = city;
		this.region = region;
		this.name = name;
		this.newName = newName;
	}
	public UpdateHouseNameDto() {
		super();
		
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNewName() {
		return newName;
	}
	public void setNewName(String newName) {
		this.newName = newName;
	}
	
}
