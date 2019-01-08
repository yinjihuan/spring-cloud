package com.fangjia.api.client.fsh.house;


import com.fangjia.api.client.fsh.house.dto.HouseInfo;
import com.fangjia.api.client.fsh.house.dto.HouseInfoDto;
import com.fangjia.api.client.fsh.house.dto.HouseListDto;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class HouseRemoteClientFallbackFactory implements FallbackFactory<HouseRemoteClient> {
    @Override
    public HouseRemoteClient create(final Throwable cause) {
        return new HouseRemoteClient() {

            @Override
            public HouseListDto hosueList(Long eid, String uid) {
                return null;
            }

            @Override
            public HouseInfoDto hosueInfo(Long houseId) {
                HouseInfoDto info = new HouseInfoDto();
                info.setData(new HouseInfo(1L, "", "", cause.getMessage()));
                return info;
            }

            @Override
            public String hello() {
                return null;
            }
        };
    }
}
