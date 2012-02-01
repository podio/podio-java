package com.podio.connection;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum ConnectionType {

	GOOGLE, OUTLOOK, VCARD;

	@Override
	@JsonValue
	public String toString() {
		return name().toLowerCase();
	}

	@JsonCreator
	public static ConnectionType getByName(String value) {
		return valueOf(value.toUpperCase());
	}
}
