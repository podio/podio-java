package com.podio.contact;

import org.codehaus.jackson.annotate.JsonProperty;

public class ProfileShort {

	/**
	 * The id of the user
	 */
	private int id;

	/**
	 * The file id of the avatar
	 */
	private Integer avatar;

	/**
	 * List of fields
	 */
	// private List<ProfileFieldValue<?>> fields;

	@JsonProperty("user_id")
	public int getId() {
		return id;
	}

	@JsonProperty("user_id")
	public void setId(int id) {
		this.id = id;
	}

	public Integer getAvatar() {
		return avatar;
	}

	public void setAvatar(Integer avatar) {
		this.avatar = avatar;
	}

	// public List<ProfileFieldValue<?>> getFields() {
	// return fields;
	// }
	//
	// public void setFields(List<ProfileFieldValue<?>> fields) {
	// this.fields = fields;
	// }
}
