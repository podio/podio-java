package com.podio.app;

import org.codehaus.jackson.annotate.JsonProperty;

public class ApplicationFieldCreateResponse {

	/**
	 * The id of the created field
	 */
	private int id;

	@JsonProperty("field_id")
	public int getId() {
		return id;
	}

	@JsonProperty("field_id")
	public void setId(int id) {
		this.id = id;
	}
}
