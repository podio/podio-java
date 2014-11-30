package com.podio.app;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class ApplicationFieldCreate implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * The type of the field (see area for more information)
	 */
	private ApplicationFieldType type;

	/**
	 * The configuration of the field
	 */
	private ApplicationFieldConfiguration configuration;

	public ApplicationFieldCreate() {
		super();
	}

	public ApplicationFieldCreate(ApplicationFieldType type,
			ApplicationFieldConfiguration configuration) {
		super();
		this.type = type;
		this.configuration = configuration;
	}

	public ApplicationFieldType getType() {
		return type;
	}

	public void setType(ApplicationFieldType type) {
		this.type = type;
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
