package com.fangjia.mqclient;

import java.util.Date;
import java.util.List;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cxytiandi.jdbc.PageQueryParam;
import com.fangjia.common.base.ResponseData;
import com.fangjia.mqclient.dto.TransactionMessage;

/**
 * 事务消息服务调用客户端
 * @author yinjihuan
 *
 */
@FeignClient(value = "transaction-mq-service", path = "/message", fallback = TransactionMqRemoteClientHystrix.class)
public interface TransactionMqRemoteClient {
	
	/**
	 * 发送消息，只存储到消息表中，发送逻辑有具体的发送线程执行
	 * @param message  消息内容
	 * @return true 成功 | false 失败
	 */
	@PostMapping("/send")
	public ResponseData sendMessage(TransactionMessage message);

	/**
	 * 批量发送消息，只存储到消息表中，发送逻辑有具体的发送线程执行
	 * @param message  消息内容
	 * @return true 成功 | false 失败
	 */
	@PostMapping("/sends")
	public ResponseData sendMessage(List<TransactionMessage> messages);

	/**
	 * 确认消息被消费
	 * @param customerSystem  消费的系统
	 * @param messageId	消息ID
	 * @return
	 */
	@GetMapping("/confirm/customer")
	public ResponseData confirmCustomerMessage(String customerSystem, Long messageId);

	/**
	 * 查询最早没有被消费的消息
	 * @param limit	查询条数
	 * @return
	 */
	@GetMapping("/wating")
	public ResponseData findByWatingMessage(int limit);

	/**
	 * 确认消息死亡
	 * @param messageId 消息ID
	 * @return
	 */
	@GetMapping("/confirm/die")
	public ResponseData confirmDieMessage(Long messageId);

	/**
	 * 累加发送次数
	 * @param messageId 消息ID
	 * @param sendDate  发送时间（task服务中的时间，防止服务器之间时间不同步问题）
	 * @return
	 */
	@GetMapping("/incrSendCount")
	public ResponseData incrSendCount(Long messageId, Date sendDate);

	/**
	 * 重新发送当前已死亡的消息
	 * @return
	 */
	@GetMapping("/send/retry")
	public ResponseData retrySendDieMessage();
	/**
	 * 分页查询具体状态的消息
	 * @param query
	 * @param status
	 * @return
	 */
	@GetMapping("/query")
	public ResponseData findMessageByPage(PageQueryParam query, int status);
	
}
