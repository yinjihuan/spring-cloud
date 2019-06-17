package com.cxytiandi.elasticsearch.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cxytiandi.elasticsearch.po.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {
	
	List<Article> findByTitleContaining(String title);
	
} 