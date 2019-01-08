package com.cxytiandi.spring_boot_example.base;

import lombok.Data;

@Data
public class ResponseData {
	
	private Boolean status = true;
	private int code = 200;
	private String message = "";
	private Object data;
	
}
