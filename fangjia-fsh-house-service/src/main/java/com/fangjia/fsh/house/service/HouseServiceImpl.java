package com.fangjia.fsh.house.service;

import java.util.ArrayList;
import java.util.List;
import com.cxytiandi.jdbc.EntityService;
import com.fangjia.fsh.house.mq.HouseProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;
import com.fangjia.fsh.house.po.HouseInfo;

@Service
public class HouseServiceImpl extends EntityService<HouseInfo> implements HouseService {
	private Logger logger = LoggerFactory.getLogger(HouseServiceImpl.class);

	@Autowired
	private HouseProcessor houseProcessor;

	@Override
	public List<HouseInfo> queryAll(Long eid, String uid) {
		List<HouseInfo> houses = new ArrayList<HouseInfo>();
		houses.add(new HouseInfo(1L, "上海", "虹口", "玉田新村"));
		houses.add(new HouseInfo(2L, "上海", "虹口", "东体小区"));
		return houses;
	}

	@Override
	public HouseInfo getHouseInfo(Long houseId) {
		//houseProcessor.addHouseOutput().send(MessageBuilder.withPayload("hello").build());
		logger.info("查询房产信息");
		//List<HouseInfo> list = super.list();
		//for (HouseInfo house : list) {
			//System.err.println(house.getName());
		//}
		try {
			Thread.sleep(100);
		} catch (Exception e){}
		return new HouseInfo(1L, "上海", "虹口", "玉田新村");
	}

}
