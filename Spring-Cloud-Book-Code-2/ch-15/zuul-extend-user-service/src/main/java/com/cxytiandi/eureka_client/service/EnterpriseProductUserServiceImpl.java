package com.cxytiandi.eureka_client.service;

import org.springframework.stereotype.Service;

import com.cxytiandi.auth.util.JWTUtils;

@Service
public class EnterpriseProductUserServiceImpl implements EnterpriseProductUserService {

    @Override
    public String login(Long eid, String uid) {
        JWTUtils jwtUtils = JWTUtils.getInstance();
        if (eid.equals(1L) && uid.equals("1001")) {
            return jwtUtils.getToken(uid);
        }
        return null;
    }
    
}
