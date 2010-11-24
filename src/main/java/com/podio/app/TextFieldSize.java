package com.podio.app;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum TextFieldSize {

	/**
	 * A small text field with a single line
	 */
	SMALL,

	/**
	 * A large text field with multiple lines
	 */
	LARGE;

	@Override
	@JsonValue
	public String toString() {
		return name().toLowerCase();
	}

	@JsonCreator()
	public static TextFieldSize getByName(String value) {
		return TextFieldSize.valueOf(value.toUpperCase());
	}
}
