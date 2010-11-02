package com.podio.serialize;

import java.io.IOException;
import java.util.TimeZone;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class TimeZoneSerializer extends JsonSerializer<TimeZone> {

	@Override
	public void serialize(TimeZone value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		jgen.writeString(value.getID());
	}

}
