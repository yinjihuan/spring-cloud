package com.fangjia.api.client.fsh.house;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * 房生活房产服务API调用客户端
 *
 * @author yinjihuan
 * @create 2017-10-27 13:55
 **/
@FeignClient("fangjia-fsh-house-service")
public interface HouseRemoteClient {

}
