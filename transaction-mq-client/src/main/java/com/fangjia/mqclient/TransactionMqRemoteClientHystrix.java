package com.fangjia.mqclient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cxytiandi.jdbc.PageQueryParam;
import com.fangjia.common.base.ResponseData;
import com.fangjia.mqclient.dto.TransactionMessage;

/**
 * 事务消息服务调用客户端
 * @author yinjihuan
 *
 */
public class TransactionMqRemoteClientHystrix implements TransactionMqRemoteClient {

	@Override
	public ResponseData sendMessage(TransactionMessage message) {
		return ResponseData.ok(false);
	}

	@Override
	public ResponseData sendMessage(List<TransactionMessage> messages) {
		return ResponseData.ok(false);
	}

	@Override
	public ResponseData confirmCustomerMessage(String customerSystem, Long messageId) {
		return ResponseData.ok(false);
	}

	@Override
	public ResponseData findByWatingMessage(int limit) {
		return ResponseData.ok(new ArrayList<TransactionMessage>());
	}

	@Override
	public ResponseData confirmDieMessage(Long messageId) {
		return ResponseData.ok(false);
	}

	@Override
	public ResponseData incrSendCount(Long messageId, Date sendDate) {
		return ResponseData.ok(false);
	}

	@Override
	public ResponseData retrySendDieMessage() {
		return ResponseData.ok(false);
	}

	@Override
	public ResponseData findMessageByPage(PageQueryParam query, int status) {
		return ResponseData.ok(new ArrayList<TransactionMessage>());
	}
	
}
