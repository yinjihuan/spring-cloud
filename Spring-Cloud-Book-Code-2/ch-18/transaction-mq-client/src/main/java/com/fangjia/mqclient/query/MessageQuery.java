package com.fangjia.mqclient.query;

import com.fangjia.mqclient.common.PageQueryParam;

public class MessageQuery extends PageQueryParam {

	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
