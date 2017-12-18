package com.fangjia.fsh.substitution.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fangjia.common.base.ResponseData;
import com.fangjia.fsh.substitution.service.SubstitutionService;

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
