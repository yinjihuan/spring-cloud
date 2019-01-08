package com.fangjia.sjdbc;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.SingleKeyDatabaseShardingAlgorithm;

public class SingleKeyDbShardingAlgorithm implements SingleKeyDatabaseShardingAlgorithm<String>  {

	 private static Map<String, List<String>> shardingMap = new ConcurrentHashMap<>();
	    
	    static {
	    	shardingMap.put("ds_0", Arrays.asList("上海"));
	    	shardingMap.put("ds_1", Arrays.asList("杭州"));
	    }
	    
	    @Override
	    public String doEqualSharding(final Collection<String> availableTargetNames, final ShardingValue<String> shardingValue) {
	        for (String each : availableTargetNames) {
	        	if (shardingMap.get(each).contains(shardingValue.getValue())) {
	        		 return each;
	        	}
	        }
	        return "ds_0";
	    }
	    
	    @Override
	    public Collection<String> doInSharding(final Collection<String> availableTargetNames, final ShardingValue<String> shardingValue) {
	    	Collection<String> result = new LinkedHashSet<>(availableTargetNames.size());
	    	for (String each : availableTargetNames) {
	         	if (shardingMap.get(each).contains(shardingValue.getValue())) {
	         		result.add(each);
	         	} else {
	         		result.add("ds_0");
	         	}
	        }
	        return result;
	    }
	    
	    @Override
	    public Collection<String> doBetweenSharding(final Collection<String> availableTargetNames, final ShardingValue<String> shardingValue) {
	    	Collection<String> result = new LinkedHashSet<>(availableTargetNames.size());
	    	for (String each : availableTargetNames) {
	         	if (shardingMap.get(each).contains(shardingValue.getValue())) {
	         		result.add(each);
	         	} else {
	         		result.add("ds_0");
	         	}
	        }
	        return result;
	    }

}
