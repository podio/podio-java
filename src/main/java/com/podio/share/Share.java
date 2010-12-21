package com.podio.share;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

import com.podio.common.Role;
import com.podio.user.UserProfileMini;

public class Share {

	/**
	 * The user the object was share with
	 */
	private UserProfileMini user;

	/**
	 * The role the user has to the object
	 */
	private Role role;

	/**
	 * The date and time the object was shared
	 */
	private DateTime grantedOn;

	/**
	 * The user who shared the item
	 */
	private UserProfileMini grantedBy;

	public UserProfileMini getUser() {
		return user;
	}

	public void setUser(UserProfileMini user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@JsonProperty("granted_on")
	public DateTime getGrantedOn() {
		return grantedOn;
	}

	@JsonProperty("granted_on")
	public void setGrantedOn(DateTime grantedOn) {
		this.grantedOn = grantedOn;
	}

	@JsonProperty("granted_by")
	public UserProfileMini getGrantedBy() {
		return grantedBy;
	}

	@JsonProperty("granted_by")
	public void setGrantedBy(UserProfileMini grantedBy) {
		this.grantedBy = grantedBy;
	}
}
