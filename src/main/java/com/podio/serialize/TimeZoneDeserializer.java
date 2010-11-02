package com.podio.serialize;

import java.io.IOException;
import java.util.TimeZone;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class TimeZoneDeserializer extends JsonDeserializer<TimeZone> {

	@Override
	public TimeZone deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		return TimeZone.getTimeZone(jp.getText());
	}
}
