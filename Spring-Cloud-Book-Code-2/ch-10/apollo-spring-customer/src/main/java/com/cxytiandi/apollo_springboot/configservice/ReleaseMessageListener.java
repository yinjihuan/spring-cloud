package com.cxytiandi.apollo_springboot.configservice;

public interface ReleaseMessageListener {
	void handleMessage(ReleaseMessage message);
}
