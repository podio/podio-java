package com.podio.user;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserStatus {

	private User user;

	private int inboxNew;

	private String taskMail;

	@XmlElement(name = "user")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@XmlElement(name = "inbox_new")
	public int getInboxNew() {
		return inboxNew;
	}

	public void setInboxNew(int inboxNew) {
		this.inboxNew = inboxNew;
	}

	@XmlElement(name = "task_mail")
	public String getTaskMail() {
		return taskMail;
	}

	public void setTaskMail(String taskMail) {
		this.taskMail = taskMail;
	}
}
