package com.fangjia.dashboard.dto;

import com.fangjia.dashboard.po.Substitution;

public class SubstitutionDto extends Substitution {
	
	private HouseInfo hosue;
	
	public void setHosue(HouseInfo hosue) {
		this.hosue = hosue;
	}
	
	public HouseInfo getHosue() {
		return hosue;
	}
}

