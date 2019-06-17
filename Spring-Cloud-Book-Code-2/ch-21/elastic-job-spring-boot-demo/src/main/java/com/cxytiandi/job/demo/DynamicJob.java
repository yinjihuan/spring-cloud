package com.cxytiandi.job.demo;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * 动态添加任务演示
 * 
 * @author yinjihuan
 *
 */
public class DynamicJob implements SimpleJob {

	@Override
	public void execute(ShardingContext shardingContext) {
		// 可以根据JobParameter来对不同的数据进行操作
		System.out.println(shardingContext.getJobParameter());
		System.out.println(shardingContext.getShardingParameter());
	}

}
