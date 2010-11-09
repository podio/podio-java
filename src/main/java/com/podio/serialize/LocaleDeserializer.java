package com.podio.serialize;

import java.io.IOException;
import java.util.Locale;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class LocaleDeserializer extends JsonDeserializer<Locale> {

	@Override
	public Locale deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		return new Locale(jp.getText());
	}
}
