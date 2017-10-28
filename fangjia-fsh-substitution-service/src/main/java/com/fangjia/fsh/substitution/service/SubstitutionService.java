package com.fangjia.fsh.substitution.service;

import com.fangjia.fsh.substitution.dto.SubstitutionDto;

/**
 * 房产置换业务
 *
 * @author yinjihuan
 * @date 2017/10/26
 */
public interface SubstitutionService {
	
	/**
	 * 获取置换信息
	 * @param sid 置换编号
	 * @return
	 */
	SubstitutionDto getSubstitutionInfo(Long sid);
	
}
