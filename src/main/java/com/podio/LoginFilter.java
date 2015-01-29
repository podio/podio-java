package com.podio;

import javax.ws.rs.core.HttpHeaders;

import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.ClientFilter;

/**
 * Filter for supplying the access token to the end point
 */
public class LoginFilter extends ClientFilter {

	private final AuthProvider authProvider;

	public LoginFilter(AuthProvider authProvider) {
		super();
		this.authProvider = authProvider;
	}

	@Override
	public ClientResponse handle(ClientRequest cr)
			throws ClientHandlerException {
		cr.getHeaders().add(HttpHeaders.AUTHORIZATION,
				"OAuth2 " + authProvider.getToken().getAccessToken());

		return getNext().handle(cr);
	}
}
