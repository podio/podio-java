package com.podio.space;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum SpaceStatus {

	ACTIVE,
	INACTIVE;

	@Override
	@JsonValue
	public String toString() {
		return name().toLowerCase();
	}

	@JsonCreator
	public static SpaceStatus getByName(String value) {
		return valueOf(value.toUpperCase());
	}
}
