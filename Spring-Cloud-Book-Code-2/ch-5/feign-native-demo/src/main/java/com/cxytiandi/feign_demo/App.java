package com.cxytiandi.feign_demo;


/**
 * Feign原生操作示列
 * 
 * @author yinjihuan
 * 
 * @about http://cxytiandi.com/about
 * 
 * @date 2019-01-01
 * 
 */
public class App {
	public static void main(String[] args) {
		HelloRemote helloRemote = RestApiCallUtils.getRestClient(HelloRemote.class,"http://localhost:8081");
		System.out.println(" 调用结果："+helloRemote.hello());
	}
}