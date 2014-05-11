package com.podio.user;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.contact.Profile;

public class UserStatus {

	private User user;

	private Profile profile;

	private Map<String, Map<String, ?>> properties;

	private int inboxNew;
	
	private int messageUnreadCount;

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

	public void setInboxNew(int inboxNew) {
		this.inboxNew = inboxNew;
	}

	@JsonProperty("message_unread_count")
	public int getMessageUnreadCount() {
		return messageUnreadCount;
	}

	public void setMessageUnreadCount(int messageUnreadCount) {
		this.messageUnreadCount = messageUnreadCount;
	}

	@JsonProperty("calendar_code")
	public String getCalendarCode() {
		return calendarCode;
	}

	public void setCalendarCode(String calendarCode) {
		this.calendarCode = calendarCode;
	}

	@JsonProperty("mailbox")
	public String getMailbox() {
		return mailbox;
	}

	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}
}
