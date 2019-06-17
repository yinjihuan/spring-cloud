package com.cxytiandi.demo;

public class UserClient {

	private UserPorperties userPorperties;
	
	public UserClient() {
		
	}
	
	public UserClient(UserPorperties p) {
		this.userPorperties = p;
	}
	
	public String getName() {
		return userPorperties.getName();
	}
	
}
