package com.cxytiandi.apollo_springboot.configservice;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;
import java.util.Map;

public class DeferredResultWrapper {
	private static final long TIMEOUT = 60 * 1000;// 60 seconds
	
	private static final ResponseEntity<List<ApolloConfigNotification>> NOT_MODIFIED_RESPONSE_LIST = new ResponseEntity<>(
			HttpStatus.NOT_MODIFIED);

	private Map<String, String> normalizedNamespaceNameToOriginalNamespaceName;
	private DeferredResult<ResponseEntity<List<ApolloConfigNotification>>> result;

	public DeferredResultWrapper() {
		result = new DeferredResult<>(TIMEOUT, NOT_MODIFIED_RESPONSE_LIST);
	}

	public void recordNamespaceNameNormalizedResult(String originalNamespaceName, String normalizedNamespaceName) {
		if (normalizedNamespaceNameToOriginalNamespaceName == null) {
			normalizedNamespaceNameToOriginalNamespaceName = Maps.newHashMap();
		}
		normalizedNamespaceNameToOriginalNamespaceName.put(normalizedNamespaceName, originalNamespaceName);
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

	/**
	 * The namespace name is used as a key in client side, so we have to return the
	 * original one instead of the correct one
	 */
	public void setResult(List<ApolloConfigNotification> notifications) {
		if (normalizedNamespaceNameToOriginalNamespaceName != null) {
			notifications.stream()
					.filter(notification -> normalizedNamespaceNameToOriginalNamespaceName
							.containsKey(notification.getNamespaceName()))
					.forEach(notification -> notification.setNamespaceName(
							normalizedNamespaceNameToOriginalNamespaceName.get(notification.getNamespaceName())));
		}

		result.setResult(new ResponseEntity<>(notifications, HttpStatus.OK));
	}

	public DeferredResult<ResponseEntity<List<ApolloConfigNotification>>> getResult() {
		return result;
	}
}