package com.cxytiandi.spring_rest_template.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseInfo {

	private Long id;
	
	private String city;
	
	private String region;
	
	private String name;
	
}
