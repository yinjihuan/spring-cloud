package com.cxytiandi.eureka_client.service;

public interface EnterpriseProductUserService {

    /**
     * 用户登录
     * @param eid   企业编号
     * @param uid   用户编号
     * @return  认证成功返回token，失败返回null
     */
    String login(Long eid, String uid);
}
