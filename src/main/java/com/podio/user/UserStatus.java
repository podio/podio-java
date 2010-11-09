package com.podio.user;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.contact.Profile;

public class UserStatus {

	private User user;

	private Profile profile;

	private Map<String, Boolean> properties;

	private int inboxNew;

	private String taskMail;

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

	public Map<String, Boolean> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Boolean> properties) {
		this.properties = properties;
	}

	@JsonProperty("inbox_new")
	public int getInboxNew() {
		return inboxNew;
	}

	@JsonProperty("inbox_new")
	public void setInboxNew(int inboxNew) {
		this.inboxNew = inboxNew;
	}

	@JsonProperty("task_mail")
	public String getTaskMail() {
		return taskMail;
	}

	@JsonProperty("task_mail")
	public void setTaskMail(String taskMail) {
		this.taskMail = taskMail;
	}
}
