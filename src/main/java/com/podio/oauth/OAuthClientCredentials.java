package com.podio.oauth;

public final class OAuthClientCredentials {

	private final String clientId;

	private final String clientSecret;

	public OAuthClientCredentials(String clientId, String clientSecret) {
		super();
		this.clientId = clientId;
		this.clientSecret = clientSecret;
	}

	@Override
	public String toString() {
		return "OAuthClientCredentials [clientId=" + clientId
				+ ", clientSecret=" + clientSecret + "]";
	}

	public String getClientId() {
		return clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

}
