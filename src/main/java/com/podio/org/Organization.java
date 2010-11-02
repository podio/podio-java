package com.podio.org;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.space.Space;

public class Organization {

	private int id;

	private String name;

	private int logo;

	private String url;

	private boolean premium;

	private String createRight;

	private List<Space> spaces;

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

	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

	@JsonProperty("create_right")
	public String getCreateRight() {
		return createRight;
	}

	@JsonProperty("create_right")
	public void setCreateRight(String createRight) {
		this.createRight = createRight;
	}

	public List<Space> getSpaces() {
		return spaces;
	}

	public void setSpaces(List<Space> spaces) {
		this.spaces = spaces;
	}
}
