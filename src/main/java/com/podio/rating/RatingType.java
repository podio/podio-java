package com.podio.rating;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum RatingType {

	/**
	 * Signals that the user approves (0) or disapproves(1)
	 */
	APPROVED,

	/**
	 * Indicates that the user can attend (0), cannot attend (1) or can maybe
	 * attend (2)
	 */
	RSVP,

	/**
	 * A rating from 1-5 where 5 is the best
	 */
	FIVESTAR,

	/**
	 * Signals the user says yes (0) or no (1)
	 */
	YESNO,

	/**
	 * Signals a thumbs up (0) or thumbs down (1)
	 */
	THUMBS,

	/**
	 * Signals the user likes the item (1)
	 */
	LIKE;

	@Override
	@JsonValue
	public String toString() {
		return name().toLowerCase();
	}

	@JsonCreator
	public static RatingType getByName(String value) {
		return valueOf(value.toUpperCase());
	}
}
