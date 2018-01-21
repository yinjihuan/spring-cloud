package com.fangjia.hystrix;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

public class App {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		HystrixRequestContext context = HystrixRequestContext.initializeContext();
	/*	String result = new MyHystrixCommand("yinjihuan").execute();
		System.out.println(result);
		Future<String> future = new MyHystrixCommand("yinjihuan").queue();
		System.out.println(future.get());*/
		
		
		/*String result = new ClearCacheHystrixCommand("yinjihuan").execute();
		System.out.println(result);
		//ClearCacheHystrixCommand.flushCache("yinjihuan");
		Future<String> future = new ClearCacheHystrixCommand("yinjihuan").queue();
		System.out.println(future.get());*/
		
	    Future<String> f1 = new MyHystrixCollapser("yinjihuan").queue();
        Future<String> f2 = new MyHystrixCollapser("yinjihuan333").queue();
        System.out.println(f1.get()+"="+f2.get());
		context.shutdown();
	}
}
