package com.podio.search;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum ReferenceTypeSearchInApp {

	APP, CONVERSATION, FILE, ITEM, PROFILE, STATUS, TASK;

	@Override
	@JsonValue
	public String toString() {
		return name().toLowerCase();
	}

	@JsonCreator
	public static ReferenceTypeSearchInApp getByName(String value) {
		return valueOf(value.toUpperCase());
	}
}
