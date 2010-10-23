package com.podio;

import java.net.URI;
import java.net.URISyntaxException;

import com.podio.oauth.OAuthClientCredentials;
import com.podio.oauth.OAuthUsernameCredentials;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public final class BaseAPI {

	private final WebResource resource;
	private LoginFilter loginFilter;

	public BaseAPI(String hostname, int port, boolean ssl,
			OAuthClientCredentials clientCredentials,
			OAuthUsernameCredentials userCredentials) {
		ClientConfig config = new DefaultClientConfig();
		config.getClasses().add(JAXBContextResolver.class);
		Client client = Client.create(config);

		URI uri;
		try {
			uri = new URI(ssl ? "https" : "http", null, hostname, port, null,
					null, null);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}

		this.resource = client.resource(uri);

		this.loginFilter = new LoginFilter(this, clientCredentials,
				userCredentials);
	}

	public WebResource getResource(String path) {
		return getResource(path, true);
	}

	public WebResource getResource(String path, boolean secure) {
		WebResource subResource = this.resource.path(path);
		if (secure) {
			subResource.addFilter(this.loginFilter);
		}

		return subResource;
	}
}
