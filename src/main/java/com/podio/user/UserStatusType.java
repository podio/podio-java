package com.podio.user;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum UserStatusType {

	INACTIVE,
	ACTIVE,
	BLACKLISTED;

	@Override
	@JsonValue
	public String toString() {
		return name().toLowerCase();
	}

	@JsonCreator
	public static UserStatusType getByName(String value) {
		return valueOf(value.toUpperCase());
	}
}
