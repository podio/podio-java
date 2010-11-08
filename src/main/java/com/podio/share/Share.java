package com.podio.share;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

import com.podio.common.Role;
import com.podio.user.UserMini;

public class Share {

	/**
	 * The user the object was share with
	 */
	private UserMini user;

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
	private UserMini grantedBy;

	public UserMini getUser() {
		return user;
	}

	public void setUser(UserMini user) {
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
	public UserMini getGrantedBy() {
		return grantedBy;
	}

	@JsonProperty("granted_by")
	public void setGrantedBy(UserMini grantedBy) {
		this.grantedBy = grantedBy;
	}
}
