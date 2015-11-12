package com.podio.app;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum DateFieldTimeEntryType {

	ENABLED,
	DISABLED,
	REQUIRED;

	@Override
	@JsonValue
	public String toString() {
		return name().toLowerCase();
	}

	@JsonCreator
	public static DateFieldTimeEntryType getByName(String value) {
		return valueOf(value.toUpperCase());
	}
}
