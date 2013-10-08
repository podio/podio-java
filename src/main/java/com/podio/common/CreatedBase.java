package com.podio.common;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

public class CreatedBase implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * The entity who created the comment
	 */
	private AuthorizationEntity createdBy;

	/**
	 * The interface through which the comment was created
	 */
	private AuthorizationInterface createdVia;

	/**
	 * The date and time the comment was created
	 */
	private DateTime createdOn;

	@JsonProperty("created_by")
	public AuthorizationEntity getCreatedBy() {
		return createdBy;
	}

	@JsonProperty("created_by")
	public void setCreatedBy(AuthorizationEntity createdBy) {
		this.createdBy = createdBy;
	}

	@JsonProperty("created_via")
	public AuthorizationInterface getCreatedVia() {
		return createdVia;
	}

	@JsonProperty("created_via")
	public void setCreatedVia(AuthorizationInterface createdVia) {
		this.createdVia = createdVia;
	}

	@JsonProperty("created_on")
	public DateTime getCreatedOn() {
		return createdOn;
	}

	@JsonProperty("created_on")
	public void setCreatedOn(DateTime createdOn) {
		this.createdOn = createdOn;
	}
}
