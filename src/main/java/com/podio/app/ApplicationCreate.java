package com.podio.app;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ApplicationCreate implements Serializable  {

	private static final long serialVersionUID = 1L;

	/**
	 * The id of the space on which the app is placed
	 */
	private int spaceId;

	/**
	 * The new configuration of the app
	 */
	private ApplicationConfigurationCreate configuration;

	private List<ApplicationFieldCreate> fields;

	public ApplicationCreate() {
		super();
	}

	public ApplicationCreate(int spaceId,
			ApplicationConfigurationCreate configuration,
			List<ApplicationFieldCreate> fields) {
		this.spaceId = spaceId;
		this.configuration = configuration;
		this.fields = fields;
	}

	@JsonProperty("space_id")
	public int getSpaceId() {
		return spaceId;
	}

	@JsonProperty("space_id")
	public void setSpaceId(int spaceId) {
		this.spaceId = spaceId;
	}

	@JsonProperty("config")
	public ApplicationConfigurationCreate getConfiguration() {
		return configuration;
	}

	@JsonProperty("config")
	public void setConfiguration(ApplicationConfigurationCreate configuration) {
		this.configuration = configuration;
	}

	public List<ApplicationFieldCreate> getFields() {
		return fields;
	}

	public void setFields(List<ApplicationFieldCreate> fields) {
		this.fields = fields;
	}
}
