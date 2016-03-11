package com.podio.app;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum ApplicationFieldType {

	/**
	 * A short text field that can hold a string
	 */
	TEXT,

	/**
	 * A field that can hold a single number with decimals.
	 */
	NUMBER,

	/**
	 * Holds an image. Can currently only be used internally by Hoist.
	 */
	IMAGE,

	/**
	 * A interval presented by a start and optional end date and optional time
	 */
	DATE,

	/**
	 * A reference to another app item.
	 */
	APP,

	/**
	 * Reference a member in the same space as the app
	 */
	MEMBER,

	/**
	 * A currency value
	 */
	MONEY,

	/**
	 * The progress of an app item.
	 */
	PROGRESS,

	/**
	 * A location in f.ex. Google maps
	 */
	LOCATION,

	/**
	 * An uploaded video file. Can currently only be used by Hoist.
	 */
	VIDEO,

	/**
	 * A duration field specified in seconds but often displayed in hours,
	 * minutes, seconds.
	 */
	DURATION,

	/**
	 * Holds a reference to a profile, which can be either a member or a contact
	 */
	CONTACT,

	/**
	 * A calculation based on fields in the same or related apps
	 */
	CALCULATION,

	/**
	 * A list of embeds
	 */
	EMBED,

	/**
	 * A category field with multiple values
	 */
	CATEGORY,

	/**
	 * A generic file field to hold many kinds of files
	 */
	FILE,
	
	/**
	 * A telephone field to hold telephone numbers properly formatted
	 */
	PHONE,
	
	/**
	 * An Email field to hold email addresses
	 */
	EMAIL,

	/**
	 * Tel field
	 */
	TEL;

	@Override
	@JsonValue
	public String toString() {
		return name().toLowerCase();
	}

	@JsonCreator()
	public static ApplicationFieldType getByName(String value) {
		return ApplicationFieldType.valueOf(value.toUpperCase());
	}
}
