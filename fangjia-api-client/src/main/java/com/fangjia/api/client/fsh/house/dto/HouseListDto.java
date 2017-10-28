package com.fangjia.api.client.fsh.house.dto;

import java.util.List;
import com.fangjia.common.base.ResponseData;

public class HouseListDto extends ResponseData {
	
	private List<HouseInfo> data;

	public List<HouseInfo> getData() {
		return data;
	}

	public void setData(List<HouseInfo> data) {
		this.data = data;
	}
	
}
