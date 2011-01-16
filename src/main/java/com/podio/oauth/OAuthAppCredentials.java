package com.podio.oauth;

import javax.ws.rs.core.MultivaluedMap;

public class OAuthAppCredentials implements OAuthUserCredentials {

	private final int appId;

	private final String appToken;

	public OAuthAppCredentials(int appId, String appToken) {
		super();
		this.appId = appId;
		this.appToken = appToken;
	}

	public String getType() {
		return "app";
	}

	public void addParameters(MultivaluedMap<String, String> map) {
		map.add("app_id", Integer.toString(appId));
		map.add("app_token", appToken);
	}

}
