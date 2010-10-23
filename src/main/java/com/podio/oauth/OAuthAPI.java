package com.podio.oauth;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.podio.BaseAPI;
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
		parameters.add("client_id", clientCredentials.getClientId());
		parameters.add("client_secret", clientCredentials.getClientSecret());
		userCredentials.addParameters(parameters);

		return baseAPI.getResource("/oauth/token", false)
				.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.post(OAuthToken.class, parameters);
	}
}
