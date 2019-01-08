package com.fangjia.fsh.house.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface HouseProcessor {

    String ADD_HOUSE_INPUT = "addHouseInput";
    String ADD_HOUSE_OUTPUT = "addHouseOutput";

    @Input(ADD_HOUSE_INPUT)
    SubscribableChannel addHouseInput();

    @Output(ADD_HOUSE_OUTPUT)
    MessageChannel addHouseOutput();

}
