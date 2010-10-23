package com.podio.oauth;

import javax.ws.rs.core.MultivaluedMap;

public class OAuthUsernameCredentials implements OAuthUserCredentials {

	private final String username;

	private final String password;

	public OAuthUsernameCredentials(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getType() {
		return "password";
	}
	
	public void addParameters(MultivaluedMap<String, String> map) {
		map.add("username", username);
		map.add("password", password);
	}	
	
}
