package com.fangjia.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;

public class MyHystrixCommand extends HystrixCommand<String> {
	private final String name;

    public MyHystrixCommand(String name) {
    /*	super(HystrixCommandGroupKey.Factory.asKey("MyGroup"));*/
        super(HystrixCommand.Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("MyGroup"))
                .andCommandPropertiesDefaults(
                		HystrixCommandProperties.Setter()
                		.withExecutionIsolationStrategy(
                				HystrixCommandProperties.ExecutionIsolationStrategy.THREAD
                		)
                ).andThreadPoolPropertiesDefaults(
                		HystrixThreadPoolProperties.Setter()
                		.withCoreSize(10)
                		.withMaxQueueSize(100)
                		.withMaximumSize(100)
                )
        );
        this.name = name;
    }
    
    @Override
    protected String getCacheKey() {
        return String.valueOf(this.name);
    }
    
    @Override
    protected String run() {
    	/*try {
			Thread.sleep(1000 * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
    	System.err.println("get data");
        return this.name + ":" + Thread.currentThread().getName();
    }
    
    @Override
    protected String getFallback() {
        return "失败了";
    }
}
