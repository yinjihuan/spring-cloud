package com.fangjia.fsh.substitution.mq;

import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fangjia.common.util.JsonUtils;
import com.fangjia.fsh.substitution.dto.MessageDto;
import com.fangjia.fsh.substitution.dto.UpdateHouseNameDto;
import com.fangjia.mqclient.TransactionMqRemoteClient;

/**
 * 可靠消息服务消费类
 * @author yinjihuan
 *
 */
@Component
public class ActiveMqConsumer {
	
	@Autowired
	private TransactionMqRemoteClient transactionMqRemoteClient;
	
	// 小区名称修改操作
	@JmsListener(destination = "house_queue")
	public void receiveQueue(TextMessage text) {
		try {
			System.out.println("可靠消息服务消费消息："+text.getText());
			MessageDto dto = JsonUtils.toBean(MessageDto.class, text.getText());
			UpdateHouseNameDto houseInfo = JsonUtils.toBean(UpdateHouseNameDto.class, dto.getMessage());
			// 执行修改操作 ....
			//System.out.println(2/0);
			// service.update(houseInfo)
			//修改成功后调用消息确认消费接口，确认该消息已被消费
			boolean result = transactionMqRemoteClient.confirmCustomerMessage("substitution-service", dto.getMessageId());
			//手动确认ACK
			if (result) {
				text.acknowledge();
			}
		} catch (Exception e) {
			// 异常时会触发重试机制，重试次数完成之后还是错误，消息会进入DLQ队列中
			throw new RuntimeException(e);
		}
		
	}
}
