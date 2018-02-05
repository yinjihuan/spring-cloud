package com.fangjia.transaction_mq.query;

import com.cxytiandi.jdbc.PageQueryParam;

public class MessageQuery extends PageQueryParam {

	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
