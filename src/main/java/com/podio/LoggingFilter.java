package com.podio;

import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.ClientFilter;

public class LoggingFilter extends ClientFilter {

	@Override
	public ClientResponse handle(ClientRequest cr)
			throws ClientHandlerException {
		System.out.println(cr.getURI());
		return getNext().handle(cr);
	}

}
