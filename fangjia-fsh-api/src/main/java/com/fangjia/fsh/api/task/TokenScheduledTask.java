package com.fangjia.fsh.api.task;

import com.fangjia.fsh.api.service.AuthService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时刷新token
 *
 * @author yinjihuan
 * @create 2017-11-09 15:39
 **/
@Component
public class TokenScheduledTask {
    private static Logger logger = LoggerFactory.getLogger(TokenScheduledTask.class);

    public final static long ONE_Minute = 60 * 1000 * 60 * 20;

    public static String token = "";

    @Autowired
    private AuthService authService;

    /**
     * 刷新Token
     */
    @Scheduled(fixedDelay = ONE_Minute)
    public void reloadApiToken() {
        token = authService.getToken();
        while (StringUtils.isBlank(token)) {
            try {
                Thread.sleep(1000);
                token = authService.getToken();
            } catch (InterruptedException e) {
                logger.error("", e);
            }
        }
    }

}
