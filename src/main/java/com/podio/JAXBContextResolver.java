package com.podio;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;

import com.podio.app.Application;
import com.podio.app.ApplicationConfiguration;
import com.podio.app.ApplicationCreate;
import com.podio.app.ApplicationCreateResponse;
import com.podio.app.ApplicationField;
import com.podio.app.ApplicationFieldConfiguration;
import com.podio.app.ApplicationFieldCreateResponse;
import com.podio.app.ApplicationFieldSettings;
import com.podio.app.ApplicationInstall;
import com.podio.oauth.OAuthToken;
import com.podio.org.Organization;
import com.podio.space.Space;
import com.podio.status.StatusCreate;
import com.podio.status.StatusCreateResponse;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.json.JSONJAXBContext;

@Provider
public class JAXBContextResolver implements ContextResolver<JAXBContext> {

	private JAXBContext context;

	private static final Class<?>[] types = new Class[] { OAuthToken.class,
			Organization.class, Space.class, Application.class,
			ApplicationConfiguration.class, ApplicationField.class,
			ApplicationFieldConfiguration.class,
			ApplicationFieldSettings.class, StatusCreate.class,
			StatusCreateResponse.class, ApplicationFieldCreateResponse.class,
			ApplicationCreate.class, ApplicationCreateResponse.class,
			ApplicationInstall.class };

	public JAXBContextResolver() throws Exception {
		this.context = new JSONJAXBContext(JSONConfiguration
				.mapped()
				.nonStrings("space_id", "required", "visible", "delta",
						"notify", "subscribe", "allow_edit", "allow_insert",
						"allow_attachments", "allow_comments", "visible",
						"fivestar", "approved", "thumbs", "rsvp", "yesno")
				.arrays("fields").build(), types);
	}

	public JAXBContext getContext(Class<?> objectType) {
		return context;
	}
}