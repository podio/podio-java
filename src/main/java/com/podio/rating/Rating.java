package com.podio.rating;

import org.joda.time.DateTime;

import com.podio.user.UserMini;

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
	private UserMini user;

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

	public UserMini getUser() {
		return user;
	}

	public void setUser(UserMini user) {
		this.user = user;
	}

	public DateTime getTime() {
		return time;
	}

	public void setTime(DateTime time) {
		this.time = time;
	}
}
