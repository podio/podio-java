package com.podio.notification;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum NotificationDateType {

	/**
	 * Ordered by when the notification was created
	 */
	CREATED,

	/**
	 * Ordered by when the notification was viewed
	 */
	VIEWED;

	@Override
	@JsonValue
	public String toString() {
		return name().toLowerCase();
	}

	@JsonCreator
	public static NotificationDateType getByName(String value) {
		return valueOf(value.toUpperCase());
	}
}
