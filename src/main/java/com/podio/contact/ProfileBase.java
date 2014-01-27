package com.podio.contact;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class ProfileBase implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * The id of the profile
	 */
	private int profileId;

	/**
	 * The id of the user
	 */
	private Integer userId;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + profileId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfileBase other = (ProfileBase) obj;
		if (profileId != other.profileId)
			return false;
		return true;
	}

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

}
