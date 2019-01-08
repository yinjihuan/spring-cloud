package com.fangjia.transaction_mq.enums;

/**
 * 消息状态枚举类
 * @author yinjihuan
 *
 */
public enum TransactionMessageStatusEnum {
	/**
	 * 等待消费
	 */
	WATING(0),
	
	/**
	 * 已消费
	 */
	OVER(1),
	
	/**
	 * 死亡
	 */
	DIE(2);
	
	private int status;
	
	public static TransactionMessageStatusEnum parse(int status) {
		for (TransactionMessageStatusEnum stat : values()) {
			if (stat.getStatus() == status) {
				return stat;
			}
		}
		return null;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	private TransactionMessageStatusEnum(int status) {
		this.status = status;
	}
}