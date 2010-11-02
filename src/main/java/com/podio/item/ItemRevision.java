package com.podio.item;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;

import com.podio.adapter.DateTimeDeserializer;
import com.podio.adapter.DateTimeSerializer;
import com.podio.user.UserMini;

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
	private UserMini user;

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

	public UserMini getUser() {
		return user;
	}

	public void setUser(UserMini user) {
		this.user = user;
	}

	@JsonProperty("created_on")
	@JsonSerialize(using = DateTimeSerializer.class)
	public DateTime getCreatedOn() {
		return createdOn;
	}

	@JsonProperty("created_on")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	public void setCreatedOn(DateTime createdOn) {
		this.createdOn = createdOn;
	}
}
