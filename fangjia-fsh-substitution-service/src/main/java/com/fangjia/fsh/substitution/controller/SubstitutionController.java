package com.fangjia.fsh.substitution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fangjia.common.base.ResponseData;
import com.fangjia.fsh.substitution.service.SubstitutionService;

/**
 * 房产置换API
 *
 * @author yinjihuan
 * @create 2017-10-28 14:07
 **/
@RestController
@RequestMapping("/substitution")
public class SubstitutionController {

	@Autowired
	private SubstitutionService substitutionService;
	
	@GetMapping("/{sid}")
	public ResponseData substitutionInfo(@PathVariable("sid") Long sid) {
		return ResponseData.ok(substitutionService.getSubstitutionInfo(sid));
	}
	
}
