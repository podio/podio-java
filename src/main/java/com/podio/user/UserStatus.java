package com.podio.user;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.contact.Profile;

public class UserStatus {

	private User user;

	private Profile profile;

	private Map<String, Map<String, ?>> properties;

	private int inboxNew;

	private String calendarCode;

	private String mailbox;

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

	public Map<String, Map<String, ?>> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Map<String, ?>> properties) {
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

	@JsonProperty("calendar_code")
	public String getCalendarCode() {
		return calendarCode;
	}

	@JsonProperty("calendar_code")
	public void setCalendarCode(String calendarCode) {
		this.calendarCode = calendarCode;
	}

	@JsonProperty("mailbox")
	public String getMailbox() {
		return mailbox;
	}

	@JsonProperty("mailbox")
	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}
}
