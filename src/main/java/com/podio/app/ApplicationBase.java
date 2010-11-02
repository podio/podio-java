package com.podio.app;

import org.codehaus.jackson.annotate.JsonProperty;

public class ApplicationBase {

	/**
	 * The current configuration of the app
	 */
	private ApplicationConfiguration configuration;

	public ApplicationBase() {
		super();
	}

	public ApplicationBase(ApplicationConfiguration configuration) {
		super();
		this.configuration = configuration;
	}

	@JsonProperty("config")
	public ApplicationConfiguration getConfiguration() {
		return configuration;
	}

	@JsonProperty("config")
	public void setConfiguration(ApplicationConfiguration configuration) {
		this.configuration = configuration;
	}
}
