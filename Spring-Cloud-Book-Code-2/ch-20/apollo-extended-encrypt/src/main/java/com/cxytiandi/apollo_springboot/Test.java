package com.cxytiandi.apollo_springboot;

import com.cxytiandi.encrypt.util.AesEncryptUtils;

public class Test {
	public static void main(String[] args) {
		String msg = "hello yinjihaun";
		try {
			String encryptMsg = AesEncryptUtils.aesEncrypt(msg, "1111222233334444");
			System.out.println(encryptMsg);
			
			msg = "[{\"id\":1,\"name\":\"jason\"}]";
			encryptMsg = AesEncryptUtils.aesEncrypt(msg, "1111222233334444");
			System.out.println(encryptMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
