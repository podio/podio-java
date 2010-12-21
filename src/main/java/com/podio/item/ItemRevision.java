package com.podio.item;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

import com.podio.user.UserProfileMini;

public class ItemRevision {

	/**
	 * The revision number
	 */
	private int revision;

	/**
	 * The revision of the app at the time this item revision was made
	 */
	private int appRevision;

	/**
	 * The user who made the revision
	 */
	private UserProfileMini user;

	/**
	 * When the revision was created
	 */
	private DateTime createdOn;

	public int getRevision() {
		return revision;
	}

	public void setRevision(int revision) {
		this.revision = revision;
	}

	@JsonProperty("app_revision")
	public int getAppRevision() {
		return appRevision;
	}

	@JsonProperty("app_revision")
	public void setAppRevision(int appRevision) {
		this.appRevision = appRevision;
	}

	public UserProfileMini getUser() {
		return user;
	}

	public void setUser(UserProfileMini user) {
		this.user = user;
	}

	@JsonProperty("created_on")
	public DateTime getCreatedOn() {
		return createdOn;
	}

	@JsonProperty("created_on")
	public void setCreatedOn(DateTime createdOn) {
		this.createdOn = createdOn;
	}
}
