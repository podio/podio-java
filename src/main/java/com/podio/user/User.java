package com.podio.user;

import java.util.Locale;
import java.util.TimeZone;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.podio.adapter.LocaleAdapter;
import com.podio.adapter.TimeZoneAdapter;

@XmlRootElement
public class User {

	private int id;

	private String mail;

	private UserType type;

	private Locale locale;

	private TimeZone timezone;

	@XmlElement(name = "user_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement(name = "mail")
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@XmlElement(name = "type")
	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	@XmlElement(name = "locale")
	@XmlJavaTypeAdapter(LocaleAdapter.class)
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	@XmlElement(name = "timezone")
	@XmlJavaTypeAdapter(TimeZoneAdapter.class)
	public TimeZone getTimezone() {
		return timezone;
	}

	public void setTimezone(TimeZone timezone) {
		this.timezone = timezone;
	}
}
