package com.podio.task;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum TaskDueStatus {

	OVERDUE,
	TODAY,
	TOMORROW,
	UPCOMING;

	@Override
	@JsonValue
	public String toString() {
		return name().toLowerCase();
	}

	@JsonCreator
	public static TaskDueStatus getByName(String value) {
		return valueOf(value.toUpperCase());
	}
}
