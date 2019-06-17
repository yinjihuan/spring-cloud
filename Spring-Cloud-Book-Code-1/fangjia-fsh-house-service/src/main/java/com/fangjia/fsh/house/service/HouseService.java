package com.fangjia.fsh.house.service;

import java.util.List;

import com.fangjia.fsh.house.po.HouseInfo;

/**
 * 房产信息业务接口
 *
 * @author yinjihuan
 * @create 2017-10-27 14:07
 **/
public interface HouseService {
	
	/**
	 * 查询企业下某个用户的所有有效的房产信息
	 * @param eid	企业编号
	 * @param uid	用户编号
	 * @return
	 */
	List<HouseInfo> queryAll(Long eid, String uid);
	
	/**
	 * 根据房产编号查询房产信息
	 * @param houseId 房产编号
	 * @return
	 */
	HouseInfo getHouseInfo(Long houseId);
	
	/**
	 * 修改信息
	 */
	boolean update(HouseInfo info);
}
