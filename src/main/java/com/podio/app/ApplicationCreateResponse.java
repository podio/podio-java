package com.podio.app;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class ApplicationCreateResponse implements Serializable {

	private static final long serialVersionUID = 1L;

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
