package com.podio.app;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class ApplicationFieldCreateResponse implements Serializable {

	private static final long serialVersionUID = 1L;

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
