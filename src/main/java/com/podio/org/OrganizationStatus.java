package com.podio.org;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum OrganizationStatus {

	ACTIVE,
	INACTIVE;

	@Override
	@JsonValue
	public String toString() {
		return name().toLowerCase();
	}

	@JsonCreator
	public static OrganizationStatus getByName(String value) {
		return valueOf(value.toUpperCase());
	}
}
