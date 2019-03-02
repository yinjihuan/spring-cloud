package com.cxytiandi.apollo_springboot.configservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

@RestController
public class NotificationControllerV2 implements ReleaseMessageListener {
	
	// 模拟配置更新，往里插入数据表示有更新
	public static Queue<String> queue = new LinkedBlockingDeque<>();

	private final Multimap<String, DeferredResultWrapper> deferredResults = Multimaps
			.synchronizedSetMultimap(HashMultimap.create());
	
	@GetMapping("/addMsg")
	public String addMsg() {
		queue.add("xxx");
		return "success";
	}
	
	@GetMapping("/getConfig")
	public DeferredResult<ResponseEntity<List<ApolloConfigNotification>>> getConfig() {
		DeferredResultWrapper deferredResultWrapper = new DeferredResultWrapper();
		List<ApolloConfigNotification> newNotifications = getApolloConfigNotifications();
		if (!CollectionUtils.isEmpty(newNotifications)) {
			deferredResultWrapper.setResult(newNotifications);
		} else {
			deferredResultWrapper.onTimeout(() -> {
				System.err.println("onTimeout");
			});

			deferredResultWrapper.onCompletion(() -> {
				System.err.println("onCompletion");
			});
			deferredResults.put("xxxx", deferredResultWrapper);
		}
		return deferredResultWrapper.getResult();
	}

	private List<ApolloConfigNotification> getApolloConfigNotifications() {
		List<ApolloConfigNotification> list = new ArrayList<>();
		String result = queue.poll();
		if (result != null) {
			list.add(new ApolloConfigNotification("application", 1));
		}
		return list;
	}
	@Override
	public void handleMessage(ReleaseMessage message) {
		System.err.println("handleMessage:"+ message);
		List<DeferredResultWrapper> results = Lists.newArrayList(deferredResults.get("xxxx"));
		for (DeferredResultWrapper deferredResultWrapper : results) {
			List<ApolloConfigNotification> list = new ArrayList<>();
			list.add(new ApolloConfigNotification("application", 1));
			deferredResultWrapper.setResult(list);
		}
	}
}
