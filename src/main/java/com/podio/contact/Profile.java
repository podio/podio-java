package com.podio.contact;

import org.codehaus.jackson.annotate.JsonProperty;

public class Profile extends ProfileUpdate {

	/**
	 * The id of the user
	 */
	private int id;

	@JsonProperty("user_id")
	public int getId() {
		return id;
	}

	@JsonProperty("user_id")
	public void setId(int userId) {
		this.id = userId;
	}
}
