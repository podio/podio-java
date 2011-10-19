package com.podio;

import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.ClientFilter;

/**
 * Used to put the API in testmode
 */
public class DryRunFilter extends ClientFilter {

	@Override
	public ClientResponse handle(ClientRequest cr)
			throws ClientHandlerException {
		if (!cr.getURI().getPath().startsWith("/oauth")) {
			cr.getHeaders().putSingle("X-Podio-Dry-Run", "steYut44");
		}

		return getNext().handle(cr);
	}

}
