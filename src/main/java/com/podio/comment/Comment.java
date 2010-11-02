package com.podio.comment;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;

import com.podio.adapter.DateTimeDeserializer;
import com.podio.adapter.DateTimeSerializer;
import com.podio.file.File;
import com.podio.user.UserMini;

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
	 * The user who created the comment
	 */
	private UserMini user;

	/**
	 * The date and time the comment was created
	 */
	private DateTime createdOn;

	/**
	 * The alerts on the comment
	 */
	private List<UserMini> alerts;

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

	public List<UserMini> getAlerts() {
		return alerts;
	}

	public void setAlerts(List<UserMini> alerts) {
		this.alerts = alerts;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}
}
