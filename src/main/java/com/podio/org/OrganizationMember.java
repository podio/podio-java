package com.podio.org;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.common.Role;
import com.podio.contact.Profile;
import com.podio.user.User;

public class OrganizationMember {

	/**
	 * The user data of the member
	 */
	private User user;

	/**
	 * The profile of the member
	 */
	private Profile profile;

	/**
	 * True if the member is an employee, false otherwise
	 */
	private boolean employee;

	/**
	 * The organization role of the user, if any, either "regular" or "admin"
	 */
	private Role role;

	/**
	 * The number of spaces the user is member of in the organization
	 */
	private int spaceMemberships;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public boolean isEmployee() {
		return employee;
	}

	public void setEmployee(boolean employee) {
		this.employee = employee;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@JsonProperty("space_memberships")
	public int getSpaceMemberships() {
		return spaceMemberships;
	}

	@JsonProperty("space_memberships")
	public void setSpaceMemberships(int spaceMemberships) {
		this.spaceMemberships = spaceMemberships;
	}

}
