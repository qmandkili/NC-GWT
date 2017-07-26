package com.rest.server;

public interface Connector {
	
	public void connect(String login, String password);
	
	public void disconnect();

}
