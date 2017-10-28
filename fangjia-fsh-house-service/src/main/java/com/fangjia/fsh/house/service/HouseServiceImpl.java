package com.fangjia.fsh.house.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.fangjia.fsh.house.po.HouseInfo;

@Service
public class HouseServiceImpl implements HouseService {

	@Override
	public List<HouseInfo> queryAll(Long eid, String uid) {
		List<HouseInfo> houses = new ArrayList<HouseInfo>();
		houses.add(new HouseInfo(1L, "上海", "虹口", "玉田新村"));
		houses.add(new HouseInfo(2L, "上海", "虹口", "东体小区"));
		return houses;
	}

	@Override
	public HouseInfo getHouseInfo(Long houseId) {
		return new HouseInfo(1L, "上海", "虹口", "玉田新村");
	}

}
