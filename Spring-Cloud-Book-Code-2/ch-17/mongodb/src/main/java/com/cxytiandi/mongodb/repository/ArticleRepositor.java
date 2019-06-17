package com.cxytiandi.mongodb.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cxytiandi.mongodb.po.Article;

@Repository("ArticleRepositor")
public interface ArticleRepositor extends PagingAndSortingRepository<Article, String> {
	// 分页查询
	public Page<Article> findAll(Pageable pageable);

	// 根据 author 查询
	public List<Article> findByAuthor(String author);

	// 根据作者和标题查询
	public List<Article> findByAuthorAndTitle(String author, String title);

	// 忽略参数大小写
	public List<Article> findByAuthorIgnoreCase(String author);

	// 忽略所有参数大小写
	public List<Article> findByAuthorAndTitleAllIgnoreCase(String author, String title);

	// 排序
	public List<Article> findByAuthorOrderByVisitCountDesc(String author);

	public List<Article> findByAuthorOrderByVisitCountAsc(String author);

	// 自带排序条件
	public List<Article> findByAuthor(String author, Sort sort);
}
