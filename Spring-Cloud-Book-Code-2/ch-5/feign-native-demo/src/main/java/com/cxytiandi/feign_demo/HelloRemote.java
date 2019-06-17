package com.cxytiandi.feign_demo;

import feign.RequestLine;

public interface HelloRemote {
	
	@RequestLine("GET /user/hello") 
	String hello();
	
}
