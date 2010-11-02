package com.podio.user;

import org.codehaus.jackson.annotate.JsonProperty;

public class UserMini {

	private int id;

	private Integer avatar;

	private String name;

	@JsonProperty("user_id")
	public int getId() {
		return id;
	}

	@JsonProperty("user_id")
	public void setId(int id) {
		this.id = id;
	}

	public Integer getAvatar() {
		return avatar;
	}

	public void setAvatar(Integer avatar) {
		this.avatar = avatar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
