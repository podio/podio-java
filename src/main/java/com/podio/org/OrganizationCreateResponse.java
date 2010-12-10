package com.podio.org;

import org.codehaus.jackson.annotate.JsonProperty;

public class OrganizationCreateResponse {

	/**
	 * The id of the newly created organization
	 */
	private int id;

	/**
	 * The full URL of the organization
	 */
	private String url;

	public int getId() {
		return id;
	}

	@JsonProperty("org_id")
	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
