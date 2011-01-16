package com.podio.common;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum AvatarType {

	FILE,
	ICON;

	@Override
	@JsonValue
	public String toString() {
		return name().toLowerCase();
	}

	@JsonCreator
	public static AvatarType getByName(String value) {
		return valueOf(value.toUpperCase());
	}
}
