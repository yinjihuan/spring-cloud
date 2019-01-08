package com.fangjia.api.client.fsh.house;

import com.fangjia.api.client.fsh.house.dto.HouseInfoDto;
import com.fangjia.api.client.fsh.house.dto.HouseListDto;
import org.springframework.stereotype.Component;

/**
 * 房产服务调用熔断默认返回处理
 *
 * @author yinjihuan
 * @create 2017-10-29 14:30
 **/
@Component
public class HouseRemoteClientHystrix implements HouseRemoteClient {

    @Override
    public HouseListDto hosueList(Long eid, String uid) {
        return new HouseListDto();
    }

    @Override
    public HouseInfoDto hosueInfo(Long houseId) {
        return new HouseInfoDto();
    }

    @Override
    public String hello() {
        return null;
    }
}
