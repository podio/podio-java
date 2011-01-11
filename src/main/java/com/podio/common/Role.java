package com.podio.common;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum Role {

	LIGHT,
	REGULAR,
	ADMIN;

	@Override
	@JsonValue
	public String toString() {
		return name().toLowerCase();
	}

	@JsonCreator
	public static Role getByName(String value) {
		return valueOf(value.toUpperCase());
	}
}
