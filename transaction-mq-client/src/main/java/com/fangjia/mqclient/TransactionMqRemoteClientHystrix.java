package com.fangjia.mqclient;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.fangjia.mqclient.dto.TransactionMessage;
import com.fangjia.mqclient.query.MessageQuery;

/**
 * 事务消息服务调用客户端
 * @author yinjihuan
 *
 */
@Component
public class TransactionMqRemoteClientHystrix implements TransactionMqRemoteClient {

	@Override
	public boolean sendMessage(TransactionMessage message) {
		return false;
	}

	@Override
	public boolean sendMessage(List<TransactionMessage> messages) {
		return false;
	}

	@Override
	public boolean confirmCustomerMessage(String customerSystem, Long messageId) {
		return false;
	}

	@Override
	public List<TransactionMessage> findByWatingMessage(int limit) {
		return new ArrayList<TransactionMessage>();
	}

	@Override
	public boolean confirmDieMessage(Long messageId) {
		return false;
	}

	@Override
	public boolean incrSendCount(Long messageId, String sendDate) {
		return false;
	}

	@Override
	public boolean retrySendDieMessage() {
		return false;
	}

	@Override
	public List<TransactionMessage> findMessageByPage(MessageQuery query) {
		return new ArrayList<TransactionMessage>();
	}
	
}
