package com.cxytiandi.mongodb.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxytiandi.mongodb.batchupdate.BathUpdateOptions;
import com.cxytiandi.mongodb.batchupdate.MongoBaseDao;
import com.cxytiandi.mongodb.po.Article;
import com.cxytiandi.mongodb.repository.ArticleRepositor;
import com.mongodb.client.ListIndexesIterable;

@RestController
public class ArticleController {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private ArticleRepositor articleRepositor;
	
	@GetMapping("/save")
	public String save() {
		// 循环添加
		for (int i = 0; i < 10; i++) {
			Article article = new Article();
			article.setTitle("MongoTemplate 的基本使用 ");
			article.setAuthor("yinjihuan");
			article.setUrl("http://cxytiandi.com/blog/detail/" + i);
			article.setTags(Arrays.asList("java", "mongodb", "spring"));
			article.setVisitCount(0L);
			article.setAddTime(new Date());
			mongoTemplate.save(article);
		}
		return "success";
	}

	@GetMapping("/batchSave")
	public String batchSave() {
		// 批量添加
		List<Article> articles = new ArrayList<>(10);
		for (int i = 0; i < 10; i++) {
			Article article = new Article();
			article.setTitle("MongoTemplate 的基本使用 ");
			article.setAuthor("yinjihuan");
			article.setUrl("http://cxytiandi.com/blog/detail/" + i);
			article.setTags(Arrays.asList("java", "mongodb", "spring"));
			article.setVisitCount(0L);
			article.setAddTime(new Date());
			articles.add(article);
		}
		mongoTemplate.insert(articles, Article.class);
		return "success";
	}
	
	@GetMapping("/indexList")
	public String indexList() {
		ListIndexesIterable<Document> list = mongoTemplate.getCollection("person").listIndexes();
		for (Document document : list) {
			System.out.println(document.toJson());
		}
		return "success";
	}
	
	@GetMapping("/update")
	public String update() {
		Query query = Query.query(Criteria.where("author").is("yinjihuan")); 
		Update update = Update.update("title", "MongoTemplate")
				.set("visitCount", 10); 
		mongoTemplate.updateFirst(query, update, Article.class);
		
		query = Query.query(Criteria.where("author").is("yinjihuan"));
		update = Update.update("title", "MongoTemplate").set("visitCount", 10); 
		mongoTemplate.updateMulti(query, update, Article.class);
		
		query = Query.query(Criteria.where("author").is("jason"));
		update = Update.update("title", "MongoTemplate").set("visitCount", 10); 
		mongoTemplate.upsert(query, update, Article.class);
		
		query = Query.query(Criteria.where("author").is("jason"));
		update = Update.update("title", "MongoTemplate").set("money", 100); 
		mongoTemplate.updateMulti(query, update, Article.class);
		
		query = Query.query(Criteria.where("author").is("jason"));
		update = Update.update("title", "MongoTemplate").inc("money", 100); 
		mongoTemplate.updateMulti(query, update, Article.class);
		
		query = Query.query(Criteria.where("author").is("jason")); 
		update = Update.update("title", "MongoTemplate")
				.rename("visitCount", "vc"); 
		mongoTemplate.updateMulti(query, update, Article.class);
		
		query = Query.query(Criteria.where("author").is("jason")); 
		update = Update.update("title", "MongoTemplate").unset("vc"); 
		mongoTemplate.updateMulti(query, update, Article.class);
		
		query = Query.query(Criteria.where("author").is("yinjihuan"));
		update = Update.update("title", "MongoTemplate").pull("tags", "java"); 
		mongoTemplate.updateMulti(query, update, Article.class);
		return "success";
	}
	
	@GetMapping("/delete")
	public String delete() {
		Query query = Query.query(Criteria.where("author").is("yinjihuan")); 
		mongoTemplate.remove(query, Article.class);
		
		query = Query.query(Criteria.where("author").is("yinjihuan")); 
		mongoTemplate.remove(query, "article_info");
		
		query = Query.query(Criteria.where("author").is("yinjihuan")); 
		Article article = mongoTemplate.findAndRemove(query, Article.class);
		
		query = Query.query(Criteria.where("author").is("yinjihuan")); 
		List<Article> articles =
				mongoTemplate.findAllAndRemove(query, Article.class);
		
		mongoTemplate.dropCollection(Article.class); 
		mongoTemplate.dropCollection("article_info");
		
		mongoTemplate.getDb().drop();
		return "success";
	}
	
	@GetMapping("/query")
	public String query() {
		Query query = Query.query(Criteria.where("author").is("yinjihuan")); 
		List<Article> articles = mongoTemplate.find(query, Article.class);
		
		query = Query.query(Criteria.where("author").is("yinjihuan")); 
		Article article = mongoTemplate.findOne(query, Article.class);
		articles = mongoTemplate.findAll(Article.class);
		
		query = Query.query(Criteria.where("author").is("yinjihuan")); 
		long count = mongoTemplate.count(query, Article.class);
		
		article = mongoTemplate.findById(new ObjectId("57c6e1601e4735b2c306cdb7"), Article.class);
		
		List<String> authors = Arrays.asList("yinjihuan", "jason"); 
		query = Query.query(Criteria.where("author").in(authors)); 
		articles = mongoTemplate.find(query, Article.class);
		
		query = Query.query(Criteria.where("author").ne("yinjihuan")); 
		articles = mongoTemplate.find(query, Article.class);
		
		query = Query.query(Criteria.where("visitCount").lt(10)); 
		articles = mongoTemplate.find(query, Article.class);
		
		query = Query.query(Criteria.where("visitCount").gt(5).lt(10)); 
		articles = mongoTemplate.find(query, Article.class);
		
		query = Query.query(Criteria.where("author").regex("a")); 
		articles = mongoTemplate.find(query, Article.class);
		
		query = Query.query(Criteria.where("tags").size(3)); 
		articles = mongoTemplate.find(query, Article.class);
		
		query = Query.query(Criteria.where("").orOperator( Criteria.where("author").is("jason"), Criteria.where("visitCount").is(0)));
		articles = mongoTemplate.find(query, Article.class);
		return "success";
	}
	
	@GetMapping("/findAll")
	public Object findAll() {
		return articleRepositor.findByAuthor("yinjihuan");
	}
	
	@GetMapping("/batchUpdate")
	public Object batchUpdate() {
		List<BathUpdateOptions> list = new ArrayList<BathUpdateOptions>();
		list.add(new BathUpdateOptions(Query.query(Criteria.where("author").is("yinjihuan")),Update.update("title", "批量更新"), true, true));
		list.add(new BathUpdateOptions(Query.query(Criteria.where("author").is("jason")),Update.update("title", "批量更新"), true, true));
		int n = MongoBaseDao.bathUpdate(mongoTemplate, "article_info", list, true);
		System.out.println("受影响的行数："+n);
		return n;
	}
}
