package com.fangjia.fsh.substitution.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import com.fangjia.api.client.fsh.house.HouseRemoteClient;
import com.fangjia.api.client.fsh.house.dto.HouseInfoDto;
import com.fangjia.fsh.substitution.dto.HouseInfo;
import com.fangjia.fsh.substitution.dto.SubstitutionDto;

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
