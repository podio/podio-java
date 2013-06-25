package com.podio.app;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum CategoryOptionStatus {

	/**
	 * The option is still active
	 */
	ACTIVE,

	/**
	 * The option has been deleted
	 */
	DELETED;

	@Override
	@JsonValue
	public String toString() {
		return name().toLowerCase();
	}

	@JsonCreator()
	public static CategoryOptionStatus getByName(String value) {
		return CategoryOptionStatus.valueOf(value.toUpperCase());
	}
}
