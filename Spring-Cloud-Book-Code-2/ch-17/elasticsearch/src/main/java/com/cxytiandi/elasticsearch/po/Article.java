package com.cxytiandi.elasticsearch.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Data;

@Data
@Document(indexName = "cxytiandi", type = "article")
public class Article {
	
	@Id    
    @Field(type = FieldType.Integer)    
	private Integer id;
	
	@Field(type = FieldType.Keyword)   
	private String sid;
	
	@Field(type = FieldType.Keyword,  analyzer = "ik_max_word", searchAnalyzer = "ik_max_word") 
	private String title;
	
	@Field(type = FieldType.Keyword) 
	private String url;
	
	@Field(type = FieldType.Keyword) 
	private String content;
	
}
