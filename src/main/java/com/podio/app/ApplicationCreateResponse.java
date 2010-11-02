package com.podio.app;

import org.codehaus.jackson.annotate.JsonProperty;

public class ApplicationCreateResponse {

	/**
	 * The id of the created app
	 */
	private int id;

	@JsonProperty("app_id")
	public int getId() {
		return id;
	}

	@JsonProperty("app_id")
	public void setId(int id) {
		this.id = id;
	}
}
