package com.fangjia.transaction_mq.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.cxytiandi.jdbc.EntityService;
import com.cxytiandi.jdbc.PageQueryParam;
import com.fangjia.transaction_mq.enums.TransactionMessageStatusEnum;
import com.fangjia.transaction_mq.po.TransactionMessage;

@Service
public class TransactionMessageServiceImpl extends EntityService<TransactionMessage> implements TransactionMessageService {
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean sendMessage(TransactionMessage message) {
		if (check(message)) {
			super.save(message);
			return true;
		}
		return false;
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean sendMessage(List<TransactionMessage> messages) {
		for (TransactionMessage message : messages) {
			if (!check(message)) {
				return false;
			}
		}
		super.batchSave(messages);
		return true;
	}
	
	private boolean check(TransactionMessage message) {
		if (!StringUtils.hasText(message.getMessage()) || !StringUtils.hasText(message.getQueue())
				|| !StringUtils.hasText(message.getSendSystem())) {
			return false;
		}
		if (message.getCreateDate() == null) {
			return false;
		}
		return true;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean confirmCustomerMessage(String customerSystem, Long messageId) {
		TransactionMessage message = super.getById("id", messageId);
		if (message == null) {
			return false;
		}
		message.setCustomerDate(new Date());
		message.setStatus(TransactionMessageStatusEnum.OVER.getStatus());
		message.setCustomerSystem(customerSystem);
		super.updateByContainsFields(message, "id", TransactionMessage.UPDATE_FIELDS);
		return true;
	}

	@Override
	public List<TransactionMessage> findByWatingMessage(int limit) {
		if (limit > 1000) {
			limit = 1000;
		}
		return super.listForPage("status", TransactionMessageStatusEnum.WATING.getStatus(), 0, limit, TransactionMessage.ID_ORDERS);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean confirmDieMessage(Long messageId) {
		TransactionMessage message = super.getById("id", messageId);
		if (message == null) {
			return false;
		}
		message.setStatus(TransactionMessageStatusEnum.DIE.getStatus());
		message.setDieDate(new Date());
		super.updateByContainsFields(message, "id", TransactionMessage.UPDATE_FIELDS2);
		return true;
	}

	@Override
	public boolean incrSendCount(Long messageId, Date sendDate) {
		TransactionMessage message = super.getById("id", messageId);
		if (message == null) {
			return false;
		}
		message.setSendDate(sendDate);
		message.setSendCount(message.getSendCount() + 1);
		super.updateByContainsFields(message, "id", new String[] {"send_count", "send_date"});
		return false;
	}

	@Override
	public boolean retrySendDieMessage() {
		super.updateByContainsFields(new String[] { "status", "send_count" }, "status", 
				new Object[] { TransactionMessageStatusEnum.WATING.getStatus(), 0, TransactionMessageStatusEnum.DIE.getStatus() });
		return true;
	}

	@Override
	public List<TransactionMessage> findMessageByPage(PageQueryParam query, TransactionMessageStatusEnum status) {
		return super.listForPage("status", status.getStatus(), query.getStart(), 
				query.getLimit(), TransactionMessage.ID_ORDERS);
	}

}