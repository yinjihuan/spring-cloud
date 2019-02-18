package com.cxytiandi.zuul_demo;

import com.cxytiandi.encrypt.util.AesEncryptUtils;

public class Test {
	public static void main(String[] args) {
		try {
			System.err.println(AesEncryptUtils.aesEncrypt("{\"name\":\"yinjihuan\"}", "d7b85f6e214abcda"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
