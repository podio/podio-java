package com.podio;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

import com.podio.oauth.OAuthAPI;
import com.podio.oauth.OAuthClientCredentials;
import com.podio.oauth.OAuthRefreshTokenCredentials;
import com.podio.oauth.OAuthToken;
import com.podio.oauth.OAuthUsernameCredentials;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

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

	private void newToken() {
		this.token = oauthAPI.getToken(clientCredentials, userCredentials);
		this.expireTime = System.currentTimeMillis() + token.getExpiresIn()
				* 1000;
	}

	private void refreshToken() {
		this.token = oauthAPI.getToken(clientCredentials,
				new OAuthRefreshTokenCredentials(this.token.getRefreshToken()));
		this.expireTime = System.currentTimeMillis() + token.getExpiresIn()
				* 1000;
	}

	@Override
	public ClientResponse handle(ClientRequest cr)
			throws ClientHandlerException {
		if (token == null) {
			newToken();
		} else if (expireTime < System.currentTimeMillis() - 30 * 1000) {
			refreshToken();
		}

		if (cr.getMethod() == "GET") {
			UriBuilder b = UriBuilder.fromUri(cr.getURI());
			b.queryParam("oauth_token", this.token.getAccessToken());
			cr.setURI(b.build());
		} else {
			System.out.println(cr.getEntity());
			MultivaluedMap<String, String> entity = (MultivaluedMap<String, String>) cr
					.getEntity();
			if (entity == null) {
				entity = new MultivaluedMapImpl();
				cr.setEntity(entity);
			}

			entity.add("oauth_token", this.token.getAccessToken());
		}

		return getNext().handle(cr);
	}
}
