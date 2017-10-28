package com.fangjia.api.client.fsh.house;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fangjia.api.client.fsh.config.FeignConfiguration;
import com.fangjia.api.client.fsh.house.dto.HouseInfoDto;
import com.fangjia.api.client.fsh.house.dto.HouseListDto;

/**
 * 房生活房产服务API调用客户端
 *
 * @author yinjihuan
 * @create 2017-10-27 13:55
 **/
@FeignClient(value = "fangjia-fsh-house-service", path = "/house", configuration = FeignConfiguration.class)
public interface HouseRemoteClient {
	
	@GetMapping("/list/{eid}/{uid}")
	public HouseListDto hosueList(@PathVariable("eid")Long eid, @PathVariable("uid")String uid);	
	
	@GetMapping("/{houseId}")
	public HouseInfoDto hosueInfo(@PathVariable("houseId")Long houseId);
	
}
