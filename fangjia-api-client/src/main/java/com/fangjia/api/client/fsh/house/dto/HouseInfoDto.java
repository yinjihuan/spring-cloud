package com.fangjia.api.client.fsh.house.dto;

import com.fangjia.common.base.ResponseData;

/**
 * 房产信息
 *
 * @author yinjihuan
 * @create 2017-10-27 13:51
 **/
public class HouseInfoDto extends ResponseData {
	private HouseInfo data;

	public HouseInfoDto(HouseInfo data) {
		data = this.data;
	}
	
	public HouseInfoDto() {
		
	}

	public HouseInfo getData() {
		return data;
	}

	public void setData(HouseInfo data) {
		this.data = data;
	}
	
}
