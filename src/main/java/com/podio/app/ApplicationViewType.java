package com.podio.app;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum ApplicationViewType {

	BADGE,
	TABLE,
	LIST,
	NODE,
	CALENDAR,
	GALLERY,
	CARD,
	STREAM;

	@Override
	@JsonValue
	public String toString() {
		return name().toLowerCase();
	}

	@JsonCreator
	public static ApplicationViewType getByName(String value) {
		return valueOf(value.toUpperCase());
	}
}
