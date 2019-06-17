package com.cxytiandi.eureka_client.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxytiandi.auth.common.ResponseData;
import com.cxytiandi.eureka_client.param.LoginParam;
import com.cxytiandi.eureka_client.service.EnterpriseProductUserService;


@RestController
@RequestMapping("/user")
public class EnterpriseProductUserController {

    @Autowired
    private EnterpriseProductUserService enterpriseProductUserService;

    @Autowired
	private HttpServletRequest request;
    
    /**
     * 用户登录
     * @param query
     * @return
     */
    @PostMapping("/login")
    public ResponseData login(@RequestBody LoginParam param) {
        if (param == null || param.getEid() == null || StringUtils.isBlank(param.getUid())) {
            return ResponseData.failByParam("eid和uid不能为空");
        }
        return ResponseData.ok(enterpriseProductUserService.login(param.getEid(), param.getUid()));
    }
    
    @GetMapping("/hello") 
    public String hello() {
    	System.err.println("用户ID:" + request.getHeader("uid"));
    	return "hello";
    }

}
