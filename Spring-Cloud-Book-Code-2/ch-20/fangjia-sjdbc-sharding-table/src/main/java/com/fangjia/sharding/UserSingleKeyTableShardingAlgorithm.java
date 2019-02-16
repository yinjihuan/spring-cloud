package com.fangjia.sharding;

import java.util.Collection;
import java.util.LinkedHashSet;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;
import com.google.common.collect.Range;

public class UserSingleKeyTableShardingAlgorithm implements SingleKeyTableShardingAlgorithm<Long>  {

	public String doEqualSharding(Collection<String> availableTargetNames, ShardingValue<Long> shardingValue) {
		for (String each : availableTargetNames) {
			System.out.println(each+"\t"+shardingValue.getValue()+"\t"+shardingValue.getValue() % 4 );
            if (each.endsWith(shardingValue.getValue() % 4 + "")) {
                return each;
            }
        }
        throw new IllegalArgumentException();
	}

	public Collection<String> doInSharding(Collection<String> availableTargetNames, ShardingValue<Long> shardingValue) {
		 Collection<String> result = new LinkedHashSet<>(availableTargetNames.size());
	        for (Long value : shardingValue.getValues()) {
	            for (String tableName : availableTargetNames) {
	                if (tableName.endsWith(value % 4 + "")) {
	                    result.add(tableName);
	                }
	            }
	        }
	        return result;
	}

	public Collection<String> doBetweenSharding(Collection<String> availableTargetNames,
			ShardingValue<Long> shardingValue) {
		Collection<String> result = new LinkedHashSet<>(availableTargetNames.size());
        Range<Long> range = (Range<Long>) shardingValue.getValueRange();
        for (Long i = range.lowerEndpoint(); i <= range.upperEndpoint(); i++) {
            for (String each : availableTargetNames) {
                if (each.endsWith(i % 4 + "")) {
                    result.add(each);
                }
            }
        }
        return result;
	}

}
