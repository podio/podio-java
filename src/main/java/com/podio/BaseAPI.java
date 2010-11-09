package com.podio;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.TimeZone;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.deser.CustomDeserializerFactory;
import org.codehaus.jackson.map.deser.StdDeserializerProvider;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;
import org.joda.time.DateTime;

import com.podio.oauth.OAuthClientCredentials;
import com.podio.oauth.OAuthUsernameCredentials;
import com.podio.serialize.DateTimeDeserializer;
import com.podio.serialize.DateTimeSerializer;
import com.podio.serialize.LocaleDeserializer;
import com.podio.serialize.LocaleSerializer;
import com.podio.serialize.TimeZoneDeserializer;
import com.podio.serialize.TimeZoneSerializer;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public final class BaseAPI {

	private final WebResource resource;
	private LoginFilter loginFilter;

	public BaseAPI(String hostname, int port, boolean ssl, boolean test,
			OAuthClientCredentials clientCredentials,
			OAuthUsernameCredentials userCredentials) {
		ClientConfig config = new DefaultClientConfig();
		config.getSingletons().add(getJsonProvider());
		Client client = Client.create(config);
		if (test) {
			client.addFilter(new TestFilter());
		}

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

	private JacksonJsonProvider getJsonProvider() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		CustomSerializerFactory serializerFactory = new CustomSerializerFactory();
		serializerFactory.addSpecificMapping(DateTime.class,
				new DateTimeSerializer());
		serializerFactory.addGenericMapping(TimeZone.class,
				new TimeZoneSerializer());
		serializerFactory.addSpecificMapping(Locale.class,
				new LocaleSerializer());
		mapper.setSerializerFactory(serializerFactory);

		CustomDeserializerFactory deserializerFactory = new CustomDeserializerFactory();
		deserializerFactory.addSpecificMapping(DateTime.class,
				new DateTimeDeserializer());
		deserializerFactory.addSpecificMapping(TimeZone.class,
				new TimeZoneDeserializer());
		deserializerFactory.addSpecificMapping(Locale.class,
				new LocaleDeserializer());
		mapper.setDeserializerProvider(new StdDeserializerProvider(
				deserializerFactory));

		return new JacksonJsonProvider(mapper);
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
