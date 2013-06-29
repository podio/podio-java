package com.podio.app;

import org.codehaus.jackson.annotate.JsonProperty;

public class ApplicationField extends ApplicationFieldCreate {

	/**
	 * The id of the field
	 */
	private int id;

	/**
	 * The external id of the field
	 */
	private String externalId;
	
	/**
	 * Indicates if the field was deleted in Podio - values include "active" and "deleted".
	 */
	private String status;

	@JsonProperty("field_id")
	public int getId() {
		return id;
	}

	@JsonProperty("field_id")
	public void setId(int id) {
		this.id = id;
	}

	public String getExternalId() {
		return externalId;
	}

	@JsonProperty("external_id")
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}
	
	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}
}
