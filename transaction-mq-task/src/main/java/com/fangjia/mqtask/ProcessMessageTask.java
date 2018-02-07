package com.fangjia.mqtask;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import org.apache.commons.lang.time.DateFormatUtils;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangjia.mqclient.TransactionMqRemoteClient;
import com.fangjia.mqclient.dto.TransactionMessage;

@Service
public class ProcessMessageTask {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessMessageTask.class);
	
	@Autowired
	private TransactionMqRemoteClient transactionMqRemoteClient;
	
	@Autowired
	private Producer producer;
	
	@Autowired
	private RedissonClient redisson;
	
	private ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
	
	private Semaphore semaphore = new Semaphore(20);
	
	public void start() {
		Thread th = new Thread(new Runnable() {
			
			public void run() {
				while(true) {
					final RLock lock = redisson.getLock("transaction-mq-task");
					try {
						lock.lock();
						System.out.println("开始发送消息:" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
						int sleepTime = process();
						if (sleepTime > 0) {
							Thread.sleep(10000);
						}
					} catch (Exception e) {
						LOGGER.error("", e);
					} finally {
						lock.unlock();
					}
				}
			}
		});
		th.start();
	}
	
	private int process() throws Exception {
		int sleepTime = 10000;	//默认执行完之后等等10秒
		List<TransactionMessage> messageList = transactionMqRemoteClient.findByWatingMessage(5000);
		if (messageList.size() == 5000) {
			sleepTime = 0;
		}
		final CountDownLatch latch = new CountDownLatch(messageList.size());
		for (final TransactionMessage message : messageList) {
			semaphore.acquire();
			fixedThreadPool.execute(new Runnable() {
				
				public void run() {
					try {
						doProcess(message);
					} catch (Exception e) {
						LOGGER.error("", e);
					} finally {
						semaphore.release();
						latch.countDown();
					}
				}
			});
		}
		latch.await();
		return sleepTime;
	}
	
	private void doProcess(TransactionMessage message) {
		//检查此消息是否满足死亡条件
		if (message.getSendCount() > message.getDieCount()) {
			transactionMqRemoteClient.confirmDieMessage(message.getId());
			return;
		}
		
		//距离上次发送时间超过一分钟才继续发送
		long currentTime = System.currentTimeMillis();
		long sendTime = 0;
		if (message.getSendDate() != null) {
			sendTime = message.getSendDate().getTime();
		}
		if (currentTime - sendTime > 60000) {
			System.out.println("发送具体消息：" + message.getId());
			
			//向MQ发送消息
			MessageDto messageDto = new MessageDto();
			messageDto.setMessageId(message.getId());
			messageDto.setMessage(message.getMessage());
			producer.send(message.getQueue(), JsonUtils.toJson(messageDto));
			
			//修改消息发送次数以及最近发送时间
			transactionMqRemoteClient.incrSendCount(message.getId(), DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
			
		}
	}
}
