package com.podio.hook;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum HookStatus {

	INACTIVE, ACTIVE;

	@Override
	@JsonValue
	public String toString() {
		return name().toLowerCase();
	}

	@JsonCreator
	public static HookStatus getByName(String value) {
		return valueOf(value.toUpperCase());
	}
}
