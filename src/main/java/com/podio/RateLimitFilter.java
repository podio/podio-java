package com.podio;

import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.ClientFilter;
import java.util.List;
import javax.ws.rs.core.MultivaluedMap;

public class RateLimitFilter extends ClientFilter {

        @SuppressWarnings("unchecked")
        @Override
        public ClientResponse handle(ClientRequest cr) {
                ClientResponse response = getNext().handle(cr);
                MultivaluedMap<String, String> headers = response.getHeaders();
                if (headers != null) {
                        List<String> limitHeader = headers.get("X-Rate-Limit-Limit");
                        if (limitHeader != null && limitHeader.size() == 1) {
                                try {
                                        RateLimits.setLimit(Integer.parseInt(limitHeader.get(0)));
                                } catch (NumberFormatException nfe) {
                                        RateLimits.setLimit(null);
                                }
                        } else {
                                RateLimits.setLimit(null);
                        }
                        List<String> remainingHeader = response.getHeaders().get("X-Rate-Limit-Remaining");
                        if (remainingHeader != null && remainingHeader.size() == 1) {
                                try {
                                        RateLimits.setRemaining(Integer.parseInt(remainingHeader.get(0)));
                                } catch (NumberFormatException nfe) {
                                        RateLimits.setRemaining(null);
                                }
                        } else {
                                RateLimits.setRemaining(null);
                        }
                } else {
                        RateLimits.setLimit(null);
                        RateLimits.setRemaining(null);
                }
                return response;
        }
}
