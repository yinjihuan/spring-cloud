package com.cxytiandi.auth.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "com.cxytiandi.auth.param.AddUserParam", description = "新增用户参数") 
public class AddUserParam {
	
	@ApiModelProperty(value="ID")
	private String id;
	
	@ApiModelProperty(value="名称")
	private String name;
	
	@ApiModelProperty(value="年龄")
	private int age;
	
}
