package com.podio.user;

import org.codehaus.jackson.annotate.JsonProperty;

public class UserStatus {

	private User user;

	private int inboxNew;

	private String taskMail;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
