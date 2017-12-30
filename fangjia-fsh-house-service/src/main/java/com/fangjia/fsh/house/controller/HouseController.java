package com.fangjia.fsh.house.controller;

import com.fangjia.common.anno.ApiRateLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

	@Value("${server.port}")
	private String serverPort;

	@GetMapping("/list/{eid}/{uid}")
	public ResponseData hosueList(@PathVariable("eid")Long eid, @PathVariable("uid")String uid) {
		return ResponseData.ok(houseService.queryAll(eid, uid));
	}
	
	/**
	 * 获取房产信息
	 * @param houseId 房产编号
	 * @return 
	 */
	@ApiRateLimit(confKey = "open.api.hosueInfo")
	@GetMapping("/{houseId}")
	public ResponseData hosueInfo(@PathVariable("houseId")Long houseId, HttpServletRequest request) {
		String uid = request.getHeader("uid");
		System.err.println("==="+uid);
		return ResponseData.ok(houseService.getHouseInfo(houseId));
	}

	@GetMapping("/hello")
	public String hello() throws  Exception {
		System.err.println("call hello");
		//Thread.sleep(6000);
		return "Hello"+serverPort;
	}
}
