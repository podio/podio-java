package com.podio.user;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum UserType {

	LIGHT,
	REGULAR,
	ADMIN;

	@Override
	@JsonValue
	public String toString() {
		return name().toLowerCase();
	}

	@JsonCreator
	public static UserType getByName(String value) {
		return valueOf(value.toUpperCase());
	}
}
