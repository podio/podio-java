package com.podio;

import com.podio.oauth.OAuthToken;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.ClientFilter;

public class FileLoginFilter extends ClientFilter {

	private final AuthProvider authProvider;

	public FileLoginFilter(AuthProvider authProvider) {
		super();
		this.authProvider = authProvider;
	}

	@Override
	public ClientResponse handle(ClientRequest cr)
			throws ClientHandlerException {
		OAuthToken token = authProvider.getToken();
		cr.getHeaders().putSingle("AccessToken", token.getAccessToken());
		cr.getHeaders().putSingle("RefreshToken", token.getRefreshToken());

		return getNext().handle(cr);
	}

}
