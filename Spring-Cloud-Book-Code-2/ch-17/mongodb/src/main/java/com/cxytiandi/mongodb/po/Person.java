package com.cxytiandi.mongodb.po;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
@CompoundIndexes({ @CompoundIndex(name = "city_region_idx", def = "{'city': 1, 'region': 1}") })
public class Person {
	private String id;

	@Indexed(unique = true)
	private String name;

	@Indexed(background = true)
	private int age;

	private String city;

	private String region;
}