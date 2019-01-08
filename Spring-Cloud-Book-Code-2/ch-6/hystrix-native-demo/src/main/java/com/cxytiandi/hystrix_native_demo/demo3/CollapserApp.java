package com.cxytiandi.hystrix_native_demo.demo3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

public class CollapserApp {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		HystrixRequestContext context = HystrixRequestContext.initializeContext();
		Future<String> f1 = new MyHystrixCollapser("yinjihuan").queue();       
		Future<String> f2 = new MyHystrixCollapser("yinjihuan333").queue();      
		System.out.println(f1.get()+"="+f2.get()); 	
		context.shutdown();

	}
}
