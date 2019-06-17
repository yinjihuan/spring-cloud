package com.cxytiandi.spring_boot_admin;

import de.codecentric.boot.admin.server.domain.entities.Instance;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.domain.events.InstanceEvent;
import de.codecentric.boot.admin.server.notify.AbstractStatusChangeNotifier;
import reactor.core.publisher.Mono;
import java.util.Map;

/**
 * 服务监控钉钉通知
 * 
 * @author yinjihuan
 * 
 * @date 2018-10-11
 * 
 */
public class DingDingNotifier extends AbstractStatusChangeNotifier {


    public DingDingNotifier(InstanceRepository repository) {
        super(repository);
    }

    @Override
    protected Mono<Void> doNotify(InstanceEvent event, Instance instance) {
    	String serviceName = instance.getRegistration().getName();
    	String serviceUrl = instance.getRegistration().getServiceUrl();
    	String status = instance.getStatusInfo().getStatus();
    	Map<String, Object> details = instance.getStatusInfo().getDetails();
    	
    	StringBuilder str = new StringBuilder();
    	str.append("【" + serviceName + "】");
    	str.append("【服务地址】" + serviceUrl);
    	str.append("【状态】" + status);
    	str.append("【详情】" + JsonUtils.toJson(details));
    	System.err.println(str);
        return Mono.fromRunnable(() -> {
        	DingDingMessageUtil.sendTextMessage(str.toString());
        });
    }

}
