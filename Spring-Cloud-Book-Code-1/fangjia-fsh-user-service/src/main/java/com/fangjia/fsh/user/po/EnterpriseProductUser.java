package com.fangjia.fsh.user.po;

import java.io.Serializable;
import java.util.Date;
import com.cxytiandi.jdbc.annotation.Field;
import com.cxytiandi.jdbc.annotation.TableName;

@TableName(value = "enterprise_product_user", author = "yinjihuan", desc = "企业产品中的用户表")
public class EnterpriseProductUser implements Serializable {

	private static final long serialVersionUID = -5813079687876757814L;

	@Field(value="uid", desc="用户ID")
	private String uid;
	
	@Field(value="eid", desc="企业ID")
	private Long eid;
	
	@Field(value="add_time", desc="保存时间")
	private Date addTime;

	@Field(value="remarks", desc="备注")
	private String remarks;

	@Field(value="city", desc="城市")
	private String city;
	
	@Field(value="region", desc="区域")
	private String region;
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Long getEid() {
		return eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	
}
