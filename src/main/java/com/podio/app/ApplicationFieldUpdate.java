package com.podio.app;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class ApplicationFieldUpdate implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * The id of the field
	 */
	private int id;

	/**
	 * The configuration of the field
	 */
	private ApplicationFieldConfiguration configuration;

	public ApplicationFieldUpdate() {
		super();
	}

	public ApplicationFieldUpdate(int id,
			ApplicationFieldConfiguration configuration) {
		super();
		this.id = id;
		this.configuration = configuration;
	}

	@JsonProperty("field_id")
	public int getId() {
		return id;
	}

	@JsonProperty("field_id")
	public void setId(int id) {
		this.id = id;
	}

	@JsonProperty("config")
	public ApplicationFieldConfiguration getConfiguration() {
		return configuration;
	}

	@JsonProperty("config")
	public void setConfiguration(ApplicationFieldConfiguration configuration) {
		this.configuration = configuration;
	}
}
