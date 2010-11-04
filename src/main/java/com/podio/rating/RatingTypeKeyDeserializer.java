package com.podio.rating;

import java.io.IOException;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.KeyDeserializer;

public class RatingTypeKeyDeserializer extends KeyDeserializer {

	@Override
	public Object deserializeKey(String key, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		return RatingType.getByName(key);
	}
}
