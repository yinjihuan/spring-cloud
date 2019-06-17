package com.cxytiandi.apollo_springboot.configservice;

public class ApolloConfigNotification {
	private String namespaceName;
	private long notificationId;

	// for json converter
	public ApolloConfigNotification() {
	
	}

	public ApolloConfigNotification(String namespaceName, long notificationId) {
		this.namespaceName = namespaceName;
		this.notificationId = notificationId;
	}

	public String getNamespaceName() {
		return namespaceName;
	}

	public long getNotificationId() {
		return notificationId;
	}

	public void setNamespaceName(String namespaceName) {
		this.namespaceName = namespaceName;
	}

	@Override
	public String toString() {
		return "ApolloConfigNotification{" + "namespaceName='" + namespaceName + '\'' + ", notificationId="
				+ notificationId + '}';
	}
}