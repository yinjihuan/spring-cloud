package com.cxytiandi.mongodb.batchupdate;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class MongoBaseDao {
	
	/**
	 * 批量更新
	 * @param ordered 如果为true,一条语句更新失败，剩下的语句将不再执。如果为false,一条语句更新失败，剩下的将继续执行。默认为true。
	 * @return
	 */
	public static int bathUpdate(MongoTemplate mongoTemplate, String collName, List<BathUpdateOptions> options, boolean ordered) {
		DBObject command = new BasicDBObject();
		command.put("update", collName);
		List<BasicDBObject> updateList = new ArrayList<BasicDBObject>();
		for (BathUpdateOptions option : options) {
			BasicDBObject update = new BasicDBObject();
			update.put("q", option.getQuery().getQueryObject());
			update.put("u", option.getUpdate().getUpdateObject());
			update.put("upsert", option.isUpsert());
			update.put("multi", option.isMulti());
			updateList.add(update);
		}
		command.put("updates", updateList);
		command.put("ordered", ordered);
		
		Document commandResult = mongoTemplate.getDb().runCommand((Bson) command);
		return Integer.parseInt(commandResult.get("n").toString());
	}
	
}