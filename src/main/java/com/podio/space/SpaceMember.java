package com.podio.space;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

import com.podio.common.Role;
import com.podio.contact.ProfileMini;

public class SpaceMember {

	/**
	 * The member of the space
	 */
	private ProfileMini user;

	/**
	 * The role that the member has
	 */
	private Role role;

	/**
	 * The date and time the user was invited
	 */
	private DateTime invitedOn;

	/**
	 * The date and time the user accepted the invitation
	 */
	private DateTime startedOn;

	/**
	 * The date and item the membership was ended. Only set if membership is
	 * ended
	 */
	private DateTime endedOn;

	public ProfileMini getUser() {
		return user;
	}

	public void setUser(ProfileMini user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public DateTime getInvitedOn() {
		return invitedOn;
	}

	@JsonProperty("invited_on")
	public void setInvitedOn(DateTime invitedOn) {
		this.invitedOn = invitedOn;
	}

	public DateTime getStartedOn() {
		return startedOn;
	}

	@JsonProperty("started_on")
	public void setStartedOn(DateTime startedOn) {
		this.startedOn = startedOn;
	}

	public DateTime getEndedOn() {
		return endedOn;
	}

	@JsonProperty("ended_on")
	public void setEndedOn(DateTime endedOn) {
		this.endedOn = endedOn;
	}
}
