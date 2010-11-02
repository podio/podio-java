package com.podio.serialize;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateTimeDeserializer extends JsonDeserializer<DateTime> {

	static final DateTimeFormatter FORMAT = DateTimeFormat
			.forPattern("yyyy-MM-dd HH:mm:ss");

	@Override
	public DateTime deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		return FORMAT.parseDateTime(jp.getText());
	}
}
