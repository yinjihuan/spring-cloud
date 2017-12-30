package com.fangjia.fsh.substitution.controller;

import com.fangjia.api.client.fsh.house.HouseRemoteClient;
import com.fangjia.fsh.substitution.dto.HouseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fangjia.common.base.ResponseData;
import com.fangjia.fsh.substitution.service.SubstitutionService;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * 房产置换API
 *
 * @author yinjihuan
 * @create 2017-10-28 14:07
 **/
@RestController
@RequestMapping("/substitution")
public class SubstitutionController {

	private Logger logger = LoggerFactory.getLogger(SubstitutionController.class);

	@Autowired
	private SubstitutionService substitutionService;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HouseRemoteClient houseRemoteClient;

	@GetMapping("/callHello")
	public String callHello() {
		//return restTemplate.getForObject("http://localhost:8081/house/hello", String.class);
		//String result = restTemplate.getForObject("http://fsh-house/house/hello", String.class);
		String result = houseRemoteClient.hello();
		System.out.println("调用结果：" + result);
		return result;
	}

	/**
	 * 获取置换信息
	 * @param sid
	 * @return
	 */
	@GetMapping("/{sid}")
	public ResponseData substitutionInfo(@PathVariable("sid") Long sid, HttpServletRequest request) {
		String uid = request.getHeader("uid");
		System.err.println("==="+uid);
		logger.info("获取置换信息");
		return ResponseData.ok(substitutionService.getSubstitutionInfo(sid));
	}
	
}
