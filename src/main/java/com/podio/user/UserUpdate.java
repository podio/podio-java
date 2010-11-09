package com.podio.user;

import java.util.Locale;
import java.util.TimeZone;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

public class UserUpdate {

	/**
	 * The new email of the user
	 */
	private String mail;

	/**
	 * The users current password
	 */
	private String oldPassword;

	/**
	 * The users new password
	 */
	private String newPassword;

	/**
	 * The locale of the user
	 */
	private Locale locale;

	/**
	 * The timezone of the user
	 */
	private TimeZone timezone;

	public UserUpdate() {
		super();
	}

	public UserUpdate(String mail, String oldPassword, String newPassword,
			Locale locale, TimeZone timezone) {
		super();
		this.mail = mail;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
		this.locale = locale;
		this.timezone = timezone;
	}

	public UserUpdate(Locale locale, TimeZone timezone) {
		super();
		this.locale = locale;
		this.timezone = timezone;
	}

	@JsonSerialize(include = Inclusion.NON_NULL)
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@JsonProperty("old_password")
	@JsonSerialize(include = Inclusion.NON_NULL)
	public String getOldPassword() {
		return oldPassword;
	}

	@JsonProperty("old_password")
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	@JsonProperty("new_password")
	@JsonSerialize(include = Inclusion.NON_NULL)
	public String getNewPassword() {
		return newPassword;
	}

	@JsonProperty("new_password")
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
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
}
