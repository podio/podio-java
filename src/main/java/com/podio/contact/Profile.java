package com.podio.contact;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

public class Profile extends ProfileUpdate {

	/**
	 * The id of the profile
	 */
	private int profileId;

	/**
	 * The id of the user
	 */
	private Integer userId;
	
	/**
	 * The last time the user was seen
	 */
	private DateTime lastSeenOn;

	@JsonProperty("profile_id")
	public int getProfileId() {
		return profileId;
	}

	@JsonProperty("profile_id")
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	@JsonProperty("user_id")
	public Integer getUserId() {
		return userId;
	}

	@JsonProperty("user_id")
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@JsonProperty("last_seen_on")
	public DateTime getLastSeenOn() {
		return lastSeenOn;
	}
}
