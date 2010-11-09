package com.podio.org;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.space.Space;

public class Organization extends OrganizationMini {

	private boolean premium;

	private String createRight;

	private List<Space> spaces;

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
