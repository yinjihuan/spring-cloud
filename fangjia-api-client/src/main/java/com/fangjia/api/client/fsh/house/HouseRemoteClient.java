package com.fangjia.api.client.fsh.house;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fangjia.api.client.config.FeignConfiguration;
import com.fangjia.api.client.fsh.house.dto.HouseInfoDto;
import com.fangjia.api.client.fsh.house.dto.HouseListDto;

/**
 * 房生活房产服务API调用客户端
 *
 * @author yinjihuan
 * @create 2017-10-27 13:55
 **/
//, fallback = HouseRemoteClientHystrix.class
@FeignClient(value = "fsh-house", path = "/house", configuration = FeignConfiguration.class
		, fallbackFactory = HouseRemoteClientFallbackFactory.class)
public interface HouseRemoteClient {
	
	/**
	 * 获取企业下某用户的有效房产信息
	 * @param eid	企业编号
	 * @param uid	用户编号
	 * @return
	 */
	@GetMapping("/list/{eid}/{uid}")
	HouseListDto hosueList(@PathVariable("eid")Long eid, @PathVariable("uid")String uid);
	
	/**
	 * 获取房产详细信息
	 * @param houseId 房产编号
	 * @return
	 */
	@GetMapping("/{houseId}")
	HouseInfoDto hosueInfo(@PathVariable("houseId")Long houseId);

	@GetMapping("/hello")
    String hello();
}
