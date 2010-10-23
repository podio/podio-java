package com.podio.oauth;

import javax.ws.rs.core.MultivaluedMap;

public class OAuthRefreshTokenCredentials implements OAuthUserCredentials {

	private final String refreshToken;

	public OAuthRefreshTokenCredentials(String refreshToken) {
		super();
		this.refreshToken = refreshToken;
	}

	public String getType() {
		return "refresh_token";
	}
	
	public void addParameters(MultivaluedMap<String, String> map) {
		map.add("refresh_token", refreshToken);
	}		
}
