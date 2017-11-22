package com.fangjia.fsh.house.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fangjia.common.base.ResponseData;
import com.fangjia.fsh.house.service.HouseService;

import javax.servlet.http.HttpServletRequest;

/**
 * 房产API
 *
 * @author yinjihuan
 * @create 2017-10-28 13:07
 **/
@RestController
@RequestMapping("/house")
public class HouseController {
	
	@Autowired
	private HouseService houseService;
	
	@GetMapping("/list/{eid}/{uid}")
	public ResponseData hosueList(@PathVariable("eid")Long eid, @PathVariable("uid")String uid) {
		return ResponseData.ok(houseService.queryAll(eid, uid));
	}
	
	/**
	 * 获取房产信息
	 * @param houseId 房产编号
	 * @return 
	 */
	@GetMapping("/{houseId}")
	public ResponseData hosueInfo(@PathVariable("houseId")Long houseId, HttpServletRequest request) {
		String uid = request.getHeader("uid");
		System.err.println("==="+uid);
		return ResponseData.ok(houseService.getHouseInfo(houseId));
	}
	
}
