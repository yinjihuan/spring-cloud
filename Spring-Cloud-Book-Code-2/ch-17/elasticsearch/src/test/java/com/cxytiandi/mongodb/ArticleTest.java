package com.cxytiandi.mongodb;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cxytiandi.elasticsearch.App;
import com.cxytiandi.elasticsearch.po.Article;
import com.cxytiandi.elasticsearch.repository.ArticleRepository;
import com.cxytiandi.elasticsearch.repository.ArticleTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class ArticleTest {
	
	@Autowired
	ArticleRepository articleRepository;
	
	@Autowired
	ArticleTemplate articleTemplate;
	
	@Test
	public void testAdd() {
		Article article = new Article();
		article.setId(1);
		article.setSid("dak219dksd");
		article.setTitle("java如何突破重围");
		article.setUrl("http://baidu.com");
		article.setContent("java 及的垃圾的 的垃圾大家导入大大大");
		articleRepository.save(article);
	}
	
	@Test
	public void testList() {
		Iterable<Article> list = articleRepository.findAll();
		for (Article article : list) {
			System.out.println(article.getTitle());
		}
	}
	
	@Test
	public void testQuery() {
		Iterable<Article> list = articleRepository.findByTitleContaining("java");
		for (Article article : list) {
			System.out.println(article.getTitle());
		}
	}
	
	@Test
	public void testQueryByPage() {
		Iterable<Article> list = articleTemplate.queryByPage("java", 0, 10);
		for (Article article : list) {
			System.out.println(article.getTitle());
		}
	}
	
	@Test
	public void testQueryByTitle() {
		List<Article> list = articleTemplate.query("java");
		for (Article article : list) {
			System.out.println(article.getTitle());
		}
	}
	
	@Test
	public void testQueryTitleCount() {
		System.out.println(articleTemplate.queryTitleCount("java"));
	}
	
	@Test
	public void testQueryBySid() {
		List<Article> list = articleTemplate.query("java", "dak219dksd");
		for (Article article : list) {
			System.out.println(article.getTitle());
		}
	}
	
	@Test
	public void testQueryByOr() {
		List<Article> list = articleTemplate.queryByOr("java", "dad");
		for (Article article : list) {
			System.out.println(article.getTitle());
		}
	}
}