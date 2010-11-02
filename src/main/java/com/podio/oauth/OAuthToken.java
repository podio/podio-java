package com.podio.oauth;

import org.codehaus.jackson.annotate.JsonProperty;

public final class OAuthToken {

	private String accessToken;

	private String refreshToken;

	private int expiresIn;

	@JsonProperty("access_token")
	public String getAccessToken() {
		return accessToken;
	}

	@JsonProperty("access_token")
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@JsonProperty("refresh_token")
	public String getRefreshToken() {
		return refreshToken;
	}

	@JsonProperty("refresh_token")
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	@JsonProperty("expires_in")
	public int getExpiresIn() {
		return expiresIn;
	}

	@JsonProperty("expires_in")
	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
}
