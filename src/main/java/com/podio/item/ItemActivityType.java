package com.podio.item;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

/**
 * The type of activity
 */
public enum ItemActivityType {

	CREATION,
	UPDATE,
	DELETE,
	COMMENT,
	FILE,
	RATING;

	@Override
	@JsonValue
	public String toString() {
		return name().toLowerCase();
	}

	@JsonCreator
	public static ItemActivityType getByName(String value) {
		return valueOf(value.toUpperCase());
	}
}
