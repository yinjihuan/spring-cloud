package com.fangjia.transaction_mq.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cxytiandi.jdbc.PageQueryParam;
import com.fangjia.common.base.ResponseData;
import com.fangjia.transaction_mq.enums.TransactionMessageStatusEnum;
import com.fangjia.transaction_mq.po.TransactionMessage;
import com.fangjia.transaction_mq.service.TransactionMessageService;

/**
 * 可靠性消息接口
 * @author yinjihuan
 *
 */
@RestController
@RequestMapping(value="/message")
public class TransactionMessageController {
	
	@Autowired
	private TransactionMessageService transactionMessageService;
	
	/**
	 * 发送消息，只存储到消息表中，发送逻辑有具体的发送线程执行
	 * @param message  消息内容
	 * @return true 成功 | false 失败
	 */
	@PostMapping("/send")
	public ResponseData sendMessage(TransactionMessage message) {
		return ResponseData.ok(transactionMessageService.sendMessage(message));
	}

	/**
	 * 批量发送消息，只存储到消息表中，发送逻辑有具体的发送线程执行
	 * @param message  消息内容
	 * @return true 成功 | false 失败
	 */
	@PostMapping("/sends")
	public ResponseData sendMessage(List<TransactionMessage> messages) {
		return ResponseData.ok(transactionMessageService.sendMessage(messages));
	}

	/**
	 * 确认消息被消费
	 * @param customerSystem  消费的系统
	 * @param messageId	消息ID
	 * @return
	 */
	@GetMapping("/confirm/customer")
	public ResponseData confirmCustomerMessage(String customerSystem, Long messageId) {
		return ResponseData.ok(transactionMessageService.confirmCustomerMessage(customerSystem, messageId));
	}

	/**
	 * 查询最早没有被消费的消息
	 * @param limit	查询条数
	 * @return
	 */
	@GetMapping("/wating")
	public ResponseData findByWatingMessage(int limit) {
		return ResponseData.ok(transactionMessageService.findByWatingMessage(limit));
	}

	/**
	 * 确认消息死亡
	 * @param messageId 消息ID
	 * @return
	 */
	@GetMapping("/confirm/die")
	public ResponseData confirmDieMessage(Long messageId) {
		return ResponseData.ok(transactionMessageService.confirmDieMessage(messageId));
	}

	/**
	 * 累加发送次数
	 * @param messageId 消息ID
	 * @param sendDate  发送时间（task服务中的时间，防止服务器之间时间不同步问题）
	 * @return
	 */
	@GetMapping("/incrSendCount")
	public ResponseData incrSendCount(Long messageId, Date sendDate) {
		return ResponseData.ok(transactionMessageService.incrSendCount(messageId, sendDate));
	}

	/**
	 * 重新发送当前已死亡的消息
	 * @return
	 */
	@GetMapping("/send/retry")
	public ResponseData retrySendDieMessage() {
		return ResponseData.ok(transactionMessageService.retrySendDieMessage());
	}

	/**
	 * 分页查询具体状态的消息
	 * @param query
	 * @param status
	 * @return
	 */
	@GetMapping("/query")
	public ResponseData findMessageByPage(PageQueryParam query, int status) {
		return ResponseData.ok(transactionMessageService.findMessageByPage(query, 
				TransactionMessageStatusEnum.parse(status)));
	}
}
