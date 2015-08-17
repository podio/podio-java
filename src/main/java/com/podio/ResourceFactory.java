package com.podio;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.TimeZone;

import javax.ws.rs.core.HttpHeaders;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.map.deser.CustomDeserializerFactory;
import org.codehaus.jackson.map.deser.StdDeserializerProvider;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.podio.oauth.OAuthClientCredentials;
import com.podio.oauth.OAuthUserCredentials;
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
import com.sun.jersey.api.client.filter.GZIPContentEncodingFilter;
import com.sun.jersey.multipart.impl.MultiPartWriter;

/**
 * This is the main low level entry point to access the Podio API. Construct
 * this and pass it to the APIFactory.
 */
public final class ResourceFactory {

	private final WebResource apiResource;
	private final WebResource fileResource;

	private final LoginFilter loginFilter;

	public ResourceFactory(OAuthClientCredentials clientCredentials,
			OAuthUserCredentials userCredentials) {
		this("api.podio.com", "files.podio.com", 443, true, false,
				clientCredentials, userCredentials);
	}

	public ResourceFactory(String apiHostname, String fileHostname, int port,
			boolean ssl, boolean dryRun,
			OAuthClientCredentials clientCredentials,
			OAuthUserCredentials userCredentials) {
		ClientConfig config = new DefaultClientConfig();
		config.getSingletons().add(getJsonProvider());
		config.getClasses().add(MultiPartWriter.class);
		Client client = Client.create(config);
		client.addFilter(new GZIPContentEncodingFilter(false));
		client.addFilter(new ExceptionFilter());
		client.addFilter(new RateLimitFilter());
		if (dryRun) {
			client.addFilter(new DryRunFilter());
		}
		// client.addFilter(new LoggingFilter());

		this.apiResource = client.resource(getURI(apiHostname, port, ssl));
		apiResource.header(HttpHeaders.USER_AGENT, "Podio Java API Client");
		this.fileResource = client.resource(getURI(fileHostname, port, ssl));
		fileResource.header(HttpHeaders.USER_AGENT, "Podio Java API Client");

		AuthProvider authProvider = new AuthProvider(this, clientCredentials,
				userCredentials);
		this.loginFilter = new LoginFilter(authProvider);
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
		mapper.disable(Feature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.disable(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS);
		mapper.setSerializationInclusion(Inclusion.NON_NULL);

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

	public WebResource getFileResource(String path) {
		return getFileResource(path, true);
	}

	public WebResource getFileResource(String path, boolean secure) {
		WebResource subResource = fileResource.path(path);
		if (secure) {
			subResource.addFilter(this.loginFilter);
		}

		return subResource;
	}

	public WebResource getApiResource(String path) {
		return getApiResource(path, true);
	}

	public WebResource getApiResource(String path, boolean secure) {
		WebResource subResource = apiResource.path(path);
		if (secure) {
			subResource.addFilter(this.loginFilter);
		}

		return subResource;
	}
}
