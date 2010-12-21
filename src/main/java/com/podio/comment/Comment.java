package com.podio.comment;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

import com.podio.file.File;
import com.podio.user.UserProfileMini;

public class Comment {

	/**
	 * The id of the comment. Can be used to update and delete the comment
	 */
	private int id;

	/**
	 * The actual comment
	 */
	private String value;

	/**
	 * The external id set on the comment
	 */
	private String externalId;

	/**
	 * The user who created the comment
	 */
	private UserProfileMini user;

	/**
	 * The date and time the comment was created
	 */
	private DateTime createdOn;

	/**
	 * The alerts on the comment
	 */
	private List<UserProfileMini> alerts;

	/**
	 * The files on the comment
	 */
	private List<File> files;

	@JsonProperty("comment_id")
	public int getId() {
		return id;
	}

	@JsonProperty("comment_id")
	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@JsonProperty("external_id")
	public String getExternalId() {
		return externalId;
	}

	@JsonProperty("external_id")
	public void setExternalId(String externalId) {
		this.externalId = externalId;
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

	public List<UserProfileMini> getAlerts() {
		return alerts;
	}

	public void setAlerts(List<UserProfileMini> alerts) {
		this.alerts = alerts;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}
}
