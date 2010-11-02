package com.podio.app;

import org.codehaus.jackson.annotate.JsonProperty;

public class ApplicationInstall {

	private int spaceId;

	public ApplicationInstall() {
		super();
	}

	public ApplicationInstall(int spaceId) {
		super();
		this.spaceId = spaceId;
	}

	@JsonProperty("space_id")
	public int getSpaceId() {
		return spaceId;
	}

	@JsonProperty("space_id")
	public void setSpaceId(int spaceId) {
		this.spaceId = spaceId;
	}

}
