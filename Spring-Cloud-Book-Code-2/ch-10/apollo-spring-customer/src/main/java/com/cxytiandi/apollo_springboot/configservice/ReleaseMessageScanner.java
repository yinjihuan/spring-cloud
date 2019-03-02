package com.cxytiandi.apollo_springboot.configservice;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReleaseMessageScanner implements InitializingBean {

	@Autowired
	private NotificationControllerV2 configController;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// 定时任务从数据库扫描有没有新的配置发布
		new Thread(() -> {
			for (;;) {
				String result = NotificationControllerV2.queue.poll();
				if (result != null) {
					ReleaseMessage message = new ReleaseMessage();
					message.setMessage(result);
					configController.handleMessage(message);
				}
			}
		}).start();;
	}

}
