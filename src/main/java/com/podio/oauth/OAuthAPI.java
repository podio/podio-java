package com.podio.oauth;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.podio.BaseAPI;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class OAuthAPI {

	private final BaseAPI baseAPI;

	public OAuthAPI(BaseAPI baseAPI) {
		this.baseAPI = baseAPI;
	}

	public OAuthToken getToken(OAuthClientCredentials clientCredentials,
			OAuthUserCredentials userCredentials) {
		MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
		parameters.add("grant_type", userCredentials.getType());
		userCredentials.addParameters(parameters);

		WebResource resource = baseAPI.getApiResource("/oauth/token", false);
		resource.addFilter(new HTTPBasicAuthFilter(clientCredentials
				.getClientId(), clientCredentials.getClientSecret()));
		return resource.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
				
				.post(OAuthToken.class, parameters);
	}
}
