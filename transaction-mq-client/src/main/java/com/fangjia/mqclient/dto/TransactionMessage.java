package com.fangjia.mqclient.dto;

import java.util.Date;

public class TransactionMessage {
	private Long id;
	
	private String message;
	
	private String queue;
	
	private String sendSystem;
	
	private int sendCount;
	
	private Date createDate;
	
	private Date sendDate;
	
	private int status = 0;
	
	private int dieCount = 10;
	
	private Date customerDate;
	
	private String customerSystem;

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