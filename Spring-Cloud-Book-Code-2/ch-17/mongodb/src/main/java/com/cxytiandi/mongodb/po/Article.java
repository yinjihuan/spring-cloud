package com.cxytiandi.mongodb.po;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.cxytiandi.mongodb.autoid.GeneratedValue;

import lombok.Data;

@Data
@Document(collection = "article_info")
public class Article {
	@Id
	@GeneratedValue
	private Long id;

	@Field("title")
	private String title;

	@Field("url")
	private String url;

	@Field("author")
	private String author;

	@Field("tags")
	private List<String> tags;

	@Field("visit_count")
	private Long visitCount;

	@Field("add_time")
	private Date addTime;

}