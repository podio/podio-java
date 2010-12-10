package com.podio.org;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.space.SpaceMini;

public class OrganizationWithSpaces extends OrganizationMini {

	/**
	 * <code>true</code> if the user has the right to create new spaces,
	 * <code>false</code> otherwise
	 */
	private String createRight;

	/**
	 * The list of spaces in the organization that the user has access to
	 */
	private List<SpaceMini> spaces;

	@JsonProperty("create_right")
	public String getCreateRight() {
		return createRight;
	}

	@JsonProperty("create_right")
	public void setCreateRight(String createRight) {
		this.createRight = createRight;
	}

	public List<SpaceMini> getSpaces() {
		return spaces;
	}

	public void setSpaces(List<SpaceMini> spaces) {
		this.spaces = spaces;
	}
}
