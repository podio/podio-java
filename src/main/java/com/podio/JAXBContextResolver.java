package com.podio;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;

import com.podio.oauth.OAuthToken;
import com.podio.org.Organization;
import com.podio.space.Space;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.json.JSONJAXBContext;

@Provider
public class JAXBContextResolver implements ContextResolver<JAXBContext> {

	private JAXBContext context;

	private static final Class<?>[] types = new Class[] { OAuthToken.class,
			Organization.class, Space.class };

	public JAXBContextResolver() throws Exception {
		this.context = new JSONJAXBContext(JSONConfiguration.natural().build(),
				types);
	}

	public JAXBContext getContext(Class<?> objectType) {
		return context;
	}
}