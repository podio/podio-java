package com.podio;

import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.ClientFilter;

public class RateLimitFilter extends ClientFilter {

	@SuppressWarnings("unchecked")
	@Override
	public ClientResponse handle(ClientRequest cr) {
                ClientResponse response = getNext().handle(cr);
                RateLimits.setLimit(Integer.parseInt(response.getHeaders().get("X-Rate-Limit-Limit").get(0)));
                RateLimits.setRemaining(Integer.parseInt(response.getHeaders().get("X-Rate-Limit-Remaining").get(0)));
                return response;
	}
}
