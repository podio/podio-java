package com.podio.status;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

import com.podio.contact.ProfileMini;

/**
 * A status message posted by a user to a space
 */
public class Status {

	private int statusId;

	private int spaceId;

	private ProfileMini user;

	private String value;

	private DateTime createdOn;

	/**
	 * @return The id of the status
	 */
	public int getStatusId() {
		return statusId;
	}

	@JsonProperty("status_id")
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return The id of the space the status message is on
	 */
	public int getSpaceId() {
		return spaceId;
	}

	@JsonProperty("space_id")
	public void setSpaceId(int spaceId) {
		this.spaceId = spaceId;
	}

	/**
	 * @return The user who created the status
	 */
	public ProfileMini getUser() {
		return user;
	}

	public void setUser(ProfileMini user) {
		this.user = user;
	}

	/**
	 * @return The actual status message
	 */
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return The date and time the message was created
	 */
	public DateTime getCreatedOn() {
		return createdOn;
	}

	@JsonProperty("created_on")
	public void setCreatedOn(DateTime createdOn) {
		this.createdOn = createdOn;
	}
}
