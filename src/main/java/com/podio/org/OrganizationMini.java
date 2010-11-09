package com.podio.org;

import org.codehaus.jackson.annotate.JsonProperty;

public class OrganizationMini {

	private int id;

	private String name;

	private int logo;

	private String url;

	@JsonProperty("org_id")
	public int getId() {
		return id;
	}

	@JsonProperty("org_id")
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLogo() {
		return logo;
	}

	public void setLogo(int logo) {
		this.logo = logo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
