package com.fangjia.transaction_mq.po;

import java.util.Date;

import com.cxytiandi.jdbc.Orders;
import com.cxytiandi.jdbc.Orders.OrderyType;
import com.cxytiandi.jdbc.annotation.AutoId;
import com.cxytiandi.jdbc.annotation.Field;
import com.cxytiandi.jdbc.annotation.TableName;
import com.fangjia.transaction_mq.enums.TransactionMessageStatusEnum;

@TableName(value="transaction_message", desc="事务消息表", author="yinjihuan")
public class TransactionMessage {
	@AutoId
	@Field(value = "id", desc = "消息ID")
	private Long id;
	
	@Field(value = "message", desc = "消息内容")
	private String message;
	
	@Field(value = "queue", desc = "队列名称")
	private String queue;
	
	@Field(value = "send_system", desc = "发送消息的系统")
	private String sendSystem;
	
	@Field(value = "send_count", desc = "重复发送消息次数")
	private int sendCount;
	
	@Field(value = "c_date", desc = "创建时间")
	private Date createDate;
	
	@Field(value = "send_date", desc = "最近发送消息时间")
	private Date sendDate;
	
	@Field(value = "status", desc = "状态：0等待消费  1已消费  2已死亡")
	private int status = TransactionMessageStatusEnum.WATING.getStatus();
	
	@Field(value = "die_count", desc = "死亡次数条件，由使用方决定，默认为发送10次还没被消费则标记死亡,人工介入")
	private int dieCount = 10;
	
	@Field(value = "customer_date", desc = "消费时间")
	private Date customerDate;
	
	@Field(value = "customer_system", desc = "消费系统")
	private String customerSystem;

	@Field(value = "die_date", desc = "死亡时间")
	private Date dieDate;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getQueue() {
		return queue;
	}

	public void setQueue(String queue) {
		this.queue = queue;
	}

	public String getSendSystem() {
		return sendSystem;
	}

	public void setSendSystem(String sendSystem) {
		this.sendSystem = sendSystem;
	}

	public int getSendCount() {
		return sendCount;
	}

	public void setSendCount(int sendCount) {
		this.sendCount = sendCount;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getDieCount() {
		return dieCount;
	}

	public void setDieCount(int dieCount) {
		this.dieCount = dieCount;
	}

	public Date getCustomerDate() {
		return customerDate;
	}

	public void setCustomerDate(Date customerDate) {
		this.customerDate = customerDate;
	}

	public String getCustomerSystem() {
		return customerSystem;
	}

	public void setCustomerSystem(String customerSystem) {
		this.customerSystem = customerSystem;
	}
	
	public Date getDieDate() {
		return dieDate;
	}

	public void setDieDate(Date dieDate) {
		this.dieDate = dieDate;
	}


	public static String[] UPDATE_FIELDS = new String[] {"status", "customer_date", "customer_system"};
	
	public static String[] UPDATE_FIELDS2 = new String[] {"status", "die_date"};
	
	public static Orders[] ID_ORDERS = new Orders[] { new Orders("id", OrderyType.ASC) };
	
}