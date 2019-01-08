package com.fangjia.fsh.user.service;

import com.cxytiandi.jdbc.EntityService;
import com.fangjia.common.util.JWTUtils;
import com.fangjia.fsh.user.po.EnterpriseProductUser;
import org.springframework.stereotype.Service;

/**
 * 企业用户业务
 *
 * @author yinjihuan
 * @create 2017-11-22 14:48
 **/
@Service
public class EnterpriseProductUserServiceImpl extends EntityService<EnterpriseProductUser> implements EnterpriseProductUserService {

    @Override
    public String login(Long eid, String uid) {
        JWTUtils jwtUtils = JWTUtils.getInstance(System.getProperty("rsa.modulus"), System.getProperty("rsa.privateExponent"), System.getProperty("rsa.publicExponent"));
        if (eid.equals(1L) && uid.equals("1001")) {
            return jwtUtils.getToken(uid);
        }
        return null;
    }
}
