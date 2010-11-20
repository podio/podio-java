package com.podio;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.TimeZone;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.deser.CustomDeserializerFactory;
import org.codehaus.jackson.map.deser.StdDeserializerProvider;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.podio.oauth.OAuthClientCredentials;
import com.podio.oauth.OAuthUsernameCredentials;
import com.podio.serialize.DateTimeDeserializer;
import com.podio.serialize.DateTimeSerializer;
import com.podio.serialize.LocalDateDeserializer;
import com.podio.serialize.LocalDateSerializer;
import com.podio.serialize.LocaleDeserializer;
import com.podio.serialize.LocaleSerializer;
import com.podio.serialize.TimeZoneDeserializer;
import com.podio.serialize.TimeZoneSerializer;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public final class BaseAPI {

	private final WebResource apiResource;
	private final WebResource uploadResource;
	private final ApiLoginFilter apiLoginFilter;
	private FileLoginFilter fileLoginFilter;

	public BaseAPI(String apiHostname, String uploadHostname, int port,
			boolean ssl, boolean test,
			OAuthClientCredentials clientCredentials,
			OAuthUsernameCredentials userCredentials) {
		ClientConfig config = new DefaultClientConfig();
		config.getSingletons().add(getJsonProvider());
		Client client = Client.create(config);
		if (test) {
			client.addFilter(new TestFilter());
		}
		// client.addFilter(new LoggingFilter());

		this.apiResource = client.resource(getURI(apiHostname, port, ssl));
		this.uploadResource = client
				.resource(getURI(uploadHostname, port, ssl));

		AuthProvider authProvider = new AuthProvider(this, clientCredentials,
				userCredentials);
		this.apiLoginFilter = new ApiLoginFilter(authProvider);
		this.fileLoginFilter = new FileLoginFilter(authProvider);
	}

	private URI getURI(String hostname, int port, boolean ssl) {
		try {
			return new URI(ssl ? "https" : "http", null, hostname, port, null,
					null, null);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	private JacksonJsonProvider getJsonProvider() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);

		CustomSerializerFactory serializerFactory = new CustomSerializerFactory();
		serializerFactory.addSpecificMapping(DateTime.class,
				new DateTimeSerializer());
		serializerFactory.addSpecificMapping(LocalDate.class,
				new LocalDateSerializer());
		serializerFactory.addGenericMapping(TimeZone.class,
				new TimeZoneSerializer());
		serializerFactory.addSpecificMapping(Locale.class,
				new LocaleSerializer());
		mapper.setSerializerFactory(serializerFactory);

		CustomDeserializerFactory deserializerFactory = new CustomDeserializerFactory();
		deserializerFactory.addSpecificMapping(DateTime.class,
				new DateTimeDeserializer());
		deserializerFactory.addSpecificMapping(LocalDate.class,
				new LocalDateDeserializer());
		deserializerFactory.addSpecificMapping(TimeZone.class,
				new TimeZoneDeserializer());
		deserializerFactory.addSpecificMapping(Locale.class,
				new LocaleDeserializer());
		mapper.setDeserializerProvider(new StdDeserializerProvider(
				deserializerFactory));

		return new CustomJacksonJsonProvider(mapper);
	}

	public WebResource getUploadResource(String path) {
		return getUploadResource(path, true);
	}

	public WebResource getUploadResource(String path, boolean secure) {
		WebResource subResource = uploadResource.path(path);
		if (secure) {
			subResource.addFilter(this.fileLoginFilter);
		}

		return subResource;
	}

	public WebResource getApiResource(String path) {
		return getApiResource(path, true);
	}

	public WebResource getApiResource(String path, boolean secure) {
		WebResource subResource = apiResource.path(path);
		if (secure) {
			subResource.addFilter(this.apiLoginFilter);
		}

		return subResource;
	}
}
