package com.fangjia.mqclient.dto;

import java.util.Date;

public class TransactionMessage {
	// 消息ID
	private Long id;
	
	// 消息内容，JSON格式数据
	private String message;
	
	// 发送给哪个队列
	private String queue;
	
	// 哪个系统发送出去的
	private String sendSystem;
	
	// 发送次数，每重新发送一次+1
	private int sendCount;
	
	// 消息创建时间
	private Date createDate;
	
	// 最近发送消息时间，每发送一次更新时间
	private Date sendDate;
	
	// 状态：0等待消费  1已消费  2已死亡
	private int status = 0;
	
	// 死亡次数条件，由使用方决定，默认为发送10次还没被消费则标记死亡,人工介入
	private int dieCount = 10;
	
	// 消息被消费的时间
	private Date customerDate;
	
	// 哪个系统消费了该消息
	private String customerSystem;

	// 消息死亡时间
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

}