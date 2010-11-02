package com.podio.user;

import java.util.Locale;
import java.util.TimeZone;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.podio.adapter.TimeZoneDeserializer;
import com.podio.adapter.TimeZoneSerializer;

public class User {

	private int id;

	private String mail;

	private UserType type;

	private Locale locale;

	private TimeZone timezone;

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

	@JsonSerialize(using = TimeZoneSerializer.class)
	public TimeZone getTimezone() {
		return timezone;
	}

	@JsonDeserialize(using = TimeZoneDeserializer.class)
	public void setTimezone(TimeZone timezone) {
		this.timezone = timezone;
	}
}
