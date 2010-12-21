package com.podio.user;

import org.codehaus.jackson.annotate.JsonProperty;

public class UserMini {

	private int id;

	private String mail;

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
}
