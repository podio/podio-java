package com.podio;

import javax.ws.rs.core.UriBuilder;

import com.podio.oauth.OAuthAPI;
import com.podio.oauth.OAuthClientCredentials;
import com.podio.oauth.OAuthRefreshTokenCredentials;
import com.podio.oauth.OAuthToken;
import com.podio.oauth.OAuthUserCredentials;
import com.podio.oauth.OAuthUsernameCredentials;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.ClientFilter;

public class LoginFilter extends ClientFilter {

	private final OAuthClientCredentials clientCredentials;
	private final OAuthUsernameCredentials userCredentials;
	private final OAuthAPI oauthAPI;

	private OAuthToken token;

	private long expireTime;

	public LoginFilter(BaseAPI baseAPI,
			OAuthClientCredentials clientCredentials,
			OAuthUsernameCredentials userCredentials) {
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

	@Override
	public ClientResponse handle(ClientRequest cr)
			throws ClientHandlerException {
		if (token == null) {
			newToken();
		} else if (expireTime < System.currentTimeMillis() - 30 * 1000) {
			refreshToken();
		}

		UriBuilder b = UriBuilder.fromUri(cr.getURI());
		b.queryParam("oauth_token", this.token.getAccessToken());
		cr.setURI(b.build());

		return getNext().handle(cr);
	}
}
