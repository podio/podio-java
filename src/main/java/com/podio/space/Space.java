package com.podio.space;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

import com.podio.common.Role;
import com.podio.contact.ProfileMini;

public class Space extends SpaceMini {

	/**
	 * <code>true</code> if new apps should be announced with a status update,
	 * <code>false</code> otherwise
	 */
	private boolean postOnNewApp;

	/**
	 * <code>true</code> if new members should be announced with a status
	 * update, <code>false</code> otherwise
	 */
	private boolean postOnNewMember;

	/**
	 * The date and time the space was created
	 */
	private DateTime createdOn;

	/**
	 * The user who created the space
	 */
	private ProfileMini createdBy;

	/**
	 * The role of the active user on the space
	 */
	private Role role;

	public boolean isPostOnNewApp() {
		return postOnNewApp;
	}

	@JsonProperty("post_on_new_app")
	public void setPostOnNewApp(boolean postOnNewApp) {
		this.postOnNewApp = postOnNewApp;
	}

	public boolean isPostOnNewMember() {
		return postOnNewMember;
	}

	@JsonProperty("post_on_new_member")
	public void setPostOnNewMember(boolean postOnNewMember) {
		this.postOnNewMember = postOnNewMember;
	}

	public DateTime getCreatedOn() {
		return createdOn;
	}

	@JsonProperty("created_on")
	public void setCreatedOn(DateTime createdOn) {
		this.createdOn = createdOn;
	}

	public ProfileMini getCreatedBy() {
		return createdBy;
	}

	@JsonProperty("created_by")
	public void setCreatedBy(ProfileMini createdBy) {
		this.createdBy = createdBy;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
