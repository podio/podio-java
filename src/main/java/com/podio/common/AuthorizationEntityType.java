package com.podio.common;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum AuthorizationEntityType {

	USER, APP, SYSTEM;

	@Override
	@JsonValue
	public String toString() {
		return name().toLowerCase();
	}

	@JsonCreator
	public static AuthorizationEntityType getByName(String value) {
		return valueOf(value.toUpperCase());
	}
}
