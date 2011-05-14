package com.podio.oauth;

import javax.ws.rs.core.MultivaluedMap;

public class OAuthCodeCredentials implements OAuthUserCredentials {

	private final String code;

	private final String redirectUri;

	public OAuthCodeCredentials(String code, String redirectUri) {
		super();
		this.code = code;
		this.redirectUri = redirectUri;
	}

	public String getCode() {
		return code;
	}

	@Override
	public String getType() {
		return "authorization_code";
	}

	public void addParameters(MultivaluedMap<String, String> map) {
		map.add("code", code);
		map.add("redirect_uri", redirectUri);
	}
}
