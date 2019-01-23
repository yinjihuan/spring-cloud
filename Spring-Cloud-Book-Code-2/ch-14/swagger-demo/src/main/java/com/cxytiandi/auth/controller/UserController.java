package com.cxytiandi.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxytiandi.auth.dto.UserDto;
import com.cxytiandi.auth.param.AddUserParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags={"用户接口"})
@RestController
public class UserController {

	@ApiOperation(value = "查询用户")
	@ApiImplicitParams({
		  @ApiImplicitParam(name="id",value="用户ID",dataType="string", paramType = "query")
	})
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = UserDto.class) })
	@GetMapping("/user")
	public UserDto getUser(@RequestParam("id")String id) {
		return new UserDto();
	}
	
	@ApiOperation(value = "新增用户")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = UserDto.class) })
	@PostMapping("/user")
	public UserDto addUser(@RequestBody AddUserParam param) {
		System.err.println(param.getName());
		return new UserDto();
	}
	
}
