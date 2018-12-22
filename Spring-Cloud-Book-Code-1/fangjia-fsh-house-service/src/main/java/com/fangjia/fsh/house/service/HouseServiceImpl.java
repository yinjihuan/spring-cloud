package com.fangjia.fsh.house.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxytiandi.jdbc.EntityService;
import com.fangjia.common.util.JsonUtils;
import com.fangjia.fsh.house.dto.UpdateHouseNameDto;
import com.fangjia.fsh.house.mq.HouseProcessor;
import com.fangjia.fsh.house.po.HouseInfo;
import com.fangjia.mqclient.TransactionMqRemoteClient;
import com.fangjia.mqclient.dto.TransactionMessage;

@Service
public class HouseServiceImpl extends EntityService<HouseInfo> implements HouseService {
	private Logger logger = LoggerFactory.getLogger(HouseServiceImpl.class);

	@Autowired
	private HouseProcessor houseProcessor;

	@Autowired
	private TransactionMqRemoteClient transactionMqRemoteClient;
	
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

	@Override
	@Transactional
	public boolean update(HouseInfo info) {
		HouseInfo old = super.getById("id", info.getId());
		super.updateByContainsFields(info, "id", new String[]{ "name" });
		// 修改之后发送消息给置换服务进行名称修改操作，最终一致性
		TransactionMessage message = new TransactionMessage();
	    message.setQueue("house_queue");
	    message.setCreateDate(new Date()); 
	    message.setSendSystem("house-service");
	    message.setMessage(JsonUtils.toJson(
			    new UpdateHouseNameDto(old.getCity(), old.getRegion(), old.getName(), info.getName())
	    ));
	    
	    boolean result = transactionMqRemoteClient.sendMessage(message);
	    if (!result) {
		    throw new RuntimeException("回滚事务");
	    }
	    return result;
	}

}
