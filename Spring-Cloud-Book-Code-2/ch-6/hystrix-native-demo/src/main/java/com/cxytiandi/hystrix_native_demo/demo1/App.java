package com.cxytiandi.hystrix_native_demo.demo1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		String result = new MyHystrixCommand("yinjihuan").execute(); 
		System.out.println(result);	
		Future<String> future = new MyHystrixCommand("yinjihuan").queue();
		System.out.println(future.get()); 

	}
}
