package com.podio.user;

import java.util.Locale;
import java.util.TimeZone;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

public class User {

	private int id;

	private String mail;

	private UserType type;

	private Locale locale;

	private TimeZone timezone;

	private DateTime createdBy;

	@Override
	public String toString() {
		return "User [id=" + id + ", mail=" + mail + ", type=" + type
				+ ", locale=" + locale + ", timezone=" + timezone + "]";
	}

	@JsonProperty("user_id")
	public int getId() {
		return id;
	}

	@JsonProperty("user_id")
	public void setId(int id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public TimeZone getTimezone() {
		return timezone;
	}

	public void setTimezone(TimeZone timezone) {
		this.timezone = timezone;
	}

	@JsonProperty("created_by")
	public DateTime getCreatedBy() {
		return createdBy;
	}

	@JsonProperty("created_by")
	public void setCreatedBy(DateTime createdBy) {
		this.createdBy = createdBy;
	}
}
