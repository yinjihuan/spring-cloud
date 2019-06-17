package com.fangjia.fsh.substitution.mq;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * 房产消费类
 *
 * @author yinjihuan
 * @create 2017-11-30 18:11
 **/
@Component
public class HouseConsumer {

    @StreamListener(HouseProcessor.ADD_HOUSE_INPUT)
    public void addHouseInput(Message<String> message) {
        System.out.println("新增房产监听收到：" + message.getPayload());
    }

}
