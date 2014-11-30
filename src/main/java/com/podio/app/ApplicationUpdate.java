package com.podio.app;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ApplicationUpdate implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * The new configuration of the app
	 */
	private ApplicationConfigurationCreate configuration;

	private List<ApplicationFieldUpdate> fields;

	public ApplicationUpdate() {
		super();
	}

	public ApplicationUpdate(ApplicationConfigurationCreate configuration,
			List<ApplicationFieldUpdate> fields) {
		this.configuration = configuration;
		this.fields = fields;
	}

	@JsonProperty("config")
	public ApplicationConfigurationCreate getConfiguration() {
		return configuration;
	}

	@JsonProperty("config")
	public void setConfiguration(ApplicationConfigurationCreate configuration) {
		this.configuration = configuration;
	}

	public List<ApplicationFieldUpdate> getFields() {
		return fields;
	}

	public void setFields(List<ApplicationFieldUpdate> fields) {
		this.fields = fields;
	}
}
