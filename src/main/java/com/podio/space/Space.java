package com.podio.space;

import org.codehaus.jackson.annotate.JsonProperty;

public class Space {

	private int id;

	private String name;

	private String url;

	private String role;

	@JsonProperty("space_id")
	public int getId() {
		return id;
	}

	@JsonProperty("space_id")
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
