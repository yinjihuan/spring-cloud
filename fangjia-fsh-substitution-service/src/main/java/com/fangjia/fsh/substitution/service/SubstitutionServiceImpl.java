package com.fangjia.dashboard.service;

import com.fangjia.dashboard.dto.HouseInfo;
import com.fangjia.dashboard.dto.SubstitutionDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangjia.api.client.fsh.house.HouseRemoteClient;
import com.fangjia.api.client.fsh.house.dto.HouseInfoDto;

@Service
public class SubstitutionServiceImpl implements SubstitutionService {

	@Autowired
	private HouseRemoteClient houseRemoteClient;
	
	@Override
	public SubstitutionDto getSubstitutionInfo(Long sid) {
		SubstitutionDto dto = new SubstitutionDto();
		dto.setId(sid);
		dto.setMoney(100.12);
		HouseInfoDto houseInfoDto = houseRemoteClient.hosueInfo(1L);
		if (houseInfoDto.getCode() == 200) {
			HouseInfo info = new HouseInfo();
			if (houseInfoDto.getData() != null) {
				BeanUtils.copyProperties(houseInfoDto.getData(), info);
			}
			dto.setHosue(info);
		}
		return dto;
	}

}
