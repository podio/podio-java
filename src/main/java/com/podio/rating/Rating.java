package com.podio.rating;

import org.joda.time.DateTime;

import com.podio.contact.ProfileMini;

public class Rating {

	/**
	 * The type of rating
	 */
	private RatingType type;

	/**
	 * The value of the rating
	 */
	private int value;

	/**
	 * The user who gave the rating
	 */
	private ProfileMini user;

	/**
	 * The date and time the rating was given
	 */
	private DateTime time;

	public RatingType getType() {
		return type;
	}

	public void setType(RatingType type) {
		this.type = type;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public ProfileMini getUser() {
		return user;
	}

	public void setUser(ProfileMini user) {
		this.user = user;
	}

	public DateTime getTime() {
		return time;
	}

	public void setTime(DateTime time) {
		this.time = time;
	}
}
