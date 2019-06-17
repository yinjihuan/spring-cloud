package com.fangjia.fsh.house.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fangjia.common.anno.ApiRateLimit;
import com.fangjia.common.base.ResponseData;
import com.fangjia.fsh.house.po.HouseInfo;
import com.fangjia.fsh.house.service.HouseService;
import com.fangjia.mqclient.TransactionMqRemoteClient;
import com.fangjia.mqclient.dto.TransactionMessage;

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

	@ApiRateLimit(replenishRate=10, burstCapacity=100)
	@GetMapping("/data")
	public HouseInfo getData(@RequestParam("name") String name) {
		return new HouseInfo(1L, "上海", "虹口", "东体小区");
	}

	@GetMapping("/data/{name}")
	public String getData2(@PathVariable("name") String name) {
		return name;
	}

	@PostMapping("/save")
	public Long addData(@RequestBody HouseInfo houseInfo) {
		System.out.println(houseInfo.getName());
		return 1001L;
	}

	/**
	 * 测试可靠消息发送
	 * @return
	 */
	@GetMapping("/sendMessage")
	public Object sendMessage() {
		return houseService.update(new HouseInfo(1L, "上海", "虹口", "东体小区"));
	}
}
