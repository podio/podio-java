package com.podio.app;

import javax.xml.bind.annotation.XmlEnumValue;

public enum ApplicationFieldType {

	/**
	 * Mandatory field type that most be present in all apps.
	 */
	@XmlEnumValue("title")
	TITLE,

	/**
	 * A short text field that can hold a limited text string
	 */
	@XmlEnumValue("small_text")
	SMALL_TEXT,

	/**
	 * A large text field that can hold a arbitrary long text.
	 */
	@XmlEnumValue("large_text")
	LARGE_TEXT,

	/**
	 * A field that can hold a single number with decimals.
	 */
	@XmlEnumValue("number")
	NUMBER,

	/**
	 * A field that can hold one or more state values.
	 */
	@XmlEnumValue("state")
	STATE,

	/**
	 * Holds an image. Can currently only be used internally by Hoist.
	 */
	@XmlEnumValue("image")
	IMAGE,

	/**
	 * An embedded media typically from youtube or similar.
	 */
	@XmlEnumValue("media")
	MEDIA,

	/**
	 * A interval presented by a start and optional end date and optional time
	 */
	@XmlEnumValue("date")
	DATE,

	/**
	 * A reference to another app item.
	 */
	@XmlEnumValue("app")
	APP,

	/**
	 * Reference a member in the same space as the app
	 */
	@XmlEnumValue("member")
	MEMBER,

	/**
	 * A currency value
	 */
	@XmlEnumValue("money")
	MONEY,

	/**
	 * The progress of an app item.
	 */
	@XmlEnumValue("progress")
	PROGRESS,

	/**
	 * A location in f.ex. Google maps
	 */
	@XmlEnumValue("location")
	LOCATION,

	/**
	 * An uploaded video file. Can currently only be used by Hoist.
	 */
	@XmlEnumValue("video")
	VIDEO;
}
