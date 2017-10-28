package com.fangjia.fsh.substitution.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fangjia.common.base.ResponseData;
import com.fangjia.fsh.substitution.controller.dto.SubstitutionDto;

/**
 * 房产置换API
 *
 * @author yinjihuan
 * @create 2017-10-28 14:07
 **/
@RestController
@RequestMapping("/substitution")
public class SubstitutionController {
	
	@GetMapping("/{sid}")
	public ResponseData substitutionInfo(@PathVariable("sid") Long sid) {
		SubstitutionDto dto = new SubstitutionDto();
		dto.setId(sid);
		dto.setMoney(100.12);
		return ResponseData.ok(dto);
	}
	
}
