package com.podio.stream;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum StreamActivityType {

	COMMENT, FILE, TASK, RATING, CREATION, UPDATE, ANSWER, MEETING, REFERENCE, GRANT, PARTICIPATION, VOTE;

	@Override
	@JsonValue
	public String toString() {
		return name().toLowerCase();
	}

	@JsonCreator
	public static StreamActivityType getByName(String value) {
		return valueOf(value.toUpperCase());
	}
}
