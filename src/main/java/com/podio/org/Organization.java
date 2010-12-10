package com.podio.org;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

import com.podio.user.UserMini;

public class Organization extends OrganizationMini {

	/**
	 * The status of the organization
	 */
	private OrganizationStatus status;

	/**
	 * The user id of the owner of the organization, which is also the person
	 * who pays its use
	 */
	private int ownerId;

	/**
	 * The maximum number of users that are allowed in the organization
	 */
	private int userLimit;

	/**
	 * The date and time when the organization was created
	 */
	private DateTime createdOn;

	/**
	 * The user that created the organization
	 */
	private UserMini createdBy;

	public OrganizationStatus getStatus() {
		return status;
	}

	public void setStatus(OrganizationStatus status) {
		this.status = status;
	}

	public int getOwnerId() {
		return ownerId;
	}

	@JsonProperty("owner_id")
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public int getUserLimit() {
		return userLimit;
	}

	@JsonProperty("user_limit")
	public void setUserLimit(int userLimit) {
		this.userLimit = userLimit;
	}

	public DateTime getCreatedOn() {
		return createdOn;
	}

	@JsonProperty("created_on")
	public void setCreatedOn(DateTime createdOn) {
		this.createdOn = createdOn;
	}

	public UserMini getCreatedBy() {
		return createdBy;
	}

	@JsonProperty("created_by")
	public void setCreatedBy(UserMini createdBy) {
		this.createdBy = createdBy;
	}
}
