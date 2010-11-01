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
import com.podio.contact.Profile;
import com.podio.item.Item;
import com.podio.item.ItemCreate;
import com.podio.item.ItemCreateResponse;
import com.podio.oauth.OAuthToken;
import com.podio.org.Organization;
import com.podio.root.SystemStatus;
import com.podio.space.Space;
import com.podio.space.SpaceWithOrganization;
import com.podio.status.StatusCreate;
import com.podio.status.StatusCreateResponse;
import com.podio.user.User;
import com.podio.user.UserStatus;
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
			ApplicationInstall.class, SystemStatus.class, UserStatus.class,
			User.class, SpaceWithOrganization.class, Profile.class,
			ItemCreate.class, ItemCreateResponse.class, Item.class };

	public JAXBContextResolver() throws Exception {
		this.context = new JSONJAXBContext(JSONConfiguration
				.mapped()
				.nonStrings("space_id", "field_id", "visible", "required",
						"allow_attachments", "allow_comments", "allow_edit",
						"allow_insert", "approved", "fivestar", "rsvp",
						"yesno", "thumbs", "app_id").arrays("values", "fields")
				.attributeAsElement("value").build(), types);
	}

	public JAXBContext getContext(Class<?> objectType) {
		return context;
	}
}