package com.cxytiandi.auth.query;

/**
 * API用户认证参数类
 * @author yinjihuan
 *
 */
public class AuthQuery {
	private String accessKey;
	
	private String secretKey;
	
	public String getAccessKey() {
		return accessKey;
	}
	
	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}
	
	public String getSecretKey() {
		return secretKey;
	}
	
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
}
