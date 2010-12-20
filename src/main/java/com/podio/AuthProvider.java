package com.podio;

import com.podio.oauth.OAuthAPI;
import com.podio.oauth.OAuthClientCredentials;
import com.podio.oauth.OAuthRefreshTokenCredentials;
import com.podio.oauth.OAuthToken;
import com.podio.oauth.OAuthUserCredentials;

/**
 * Manages tokens based on client credentials and user credentials.
 */
public class AuthProvider {

	private final OAuthClientCredentials clientCredentials;
	private final OAuthUserCredentials userCredentials;
	private final OAuthAPI oauthAPI;

	private OAuthToken token;

	private long expireTime;

	public AuthProvider(ResourceFactory baseAPI,
			OAuthClientCredentials clientCredentials,
			OAuthUserCredentials userCredentials) {
		this.clientCredentials = clientCredentials;
		this.userCredentials = userCredentials;
		this.oauthAPI = new OAuthAPI(baseAPI);
	}

	private void updateToken(OAuthUserCredentials credentials) {
		this.token = oauthAPI.getToken(clientCredentials, credentials);
		this.expireTime = System.currentTimeMillis() + token.getExpiresIn()
				* 1000;
	}

	private void newToken() {
		updateToken(userCredentials);
	}

	private void refreshToken() {
		updateToken(new OAuthRefreshTokenCredentials(
				this.token.getRefreshToken()));
	}

	public synchronized OAuthToken getToken() {
		if (token == null) {
			newToken();
		} else if (expireTime < System.currentTimeMillis() - 30 * 1000) {
			refreshToken();
		}

		return token;
	}
}
