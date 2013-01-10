package com.podio.task;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum TaskStatus {

	ACTIVE, COMPLETED, DELETED;

	@Override
	@JsonValue
	public String toString() {
		return name().toLowerCase();
	}

	@JsonCreator
	public static TaskStatus getByName(String value) {
		return valueOf(value.toUpperCase());
	}
}
