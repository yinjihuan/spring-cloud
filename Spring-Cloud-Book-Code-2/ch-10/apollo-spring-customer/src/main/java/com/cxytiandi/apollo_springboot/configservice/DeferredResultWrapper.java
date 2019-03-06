package com.cxytiandi.apollo_springboot.configservice;

import com.google.common.collect.Lists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;
import java.util.List;

public class DeferredResultWrapper {
	private static final long TIMEOUT = 60 * 1000;// 60 seconds
	
	private static final ResponseEntity<List<ApolloConfigNotification>> NOT_MODIFIED_RESPONSE_LIST = 
			new ResponseEntity<>(HttpStatus.NOT_MODIFIED);

	private DeferredResult<ResponseEntity<List<ApolloConfigNotification>>> result;

	public DeferredResultWrapper() {
		result = new DeferredResult<>(TIMEOUT, NOT_MODIFIED_RESPONSE_LIST);
	}

	public void onTimeout(Runnable timeoutCallback) {
		result.onTimeout(timeoutCallback);
	}

	public void onCompletion(Runnable completionCallback) {
		result.onCompletion(completionCallback);
	}

	public void setResult(ApolloConfigNotification notification) {
		setResult(Lists.newArrayList(notification));
	}

	public void setResult(List<ApolloConfigNotification> notifications) {
		result.setResult(new ResponseEntity<>(notifications, HttpStatus.OK));
	}

	public DeferredResult<ResponseEntity<List<ApolloConfigNotification>>> getResult() {
		return result;
	}
}