package com.podio;

import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.ClientFilter;

public class ApiLoginFilter extends ClientFilter {

	private final AuthProvider authProvider;

	public ApiLoginFilter(AuthProvider authProvider) {
		super();
		this.authProvider = authProvider;
	}

	@Override
	public ClientResponse handle(ClientRequest cr)
			throws ClientHandlerException {
		UriBuilder b = UriBuilder.fromUri(cr.getURI());
		b.queryParam("oauth_token", authProvider.getToken().getAccessToken());
		cr.setURI(b.build());

		return getNext().handle(cr);
	}
}
