package com.podio.status;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

import com.podio.common.AuthorizationEntity;
import com.podio.common.AuthorizationInterface;

/**
 * A status message posted by a user to a space
 */
public class Status {

	private int statusId;

	private String value;

	private AuthorizationEntity createdBy;

	private AuthorizationInterface createdVia;

	private DateTime createdOn;

	/**
	 * @return The id of the status
	 */
	public int getStatusId() {
		return statusId;
	}

	@JsonProperty("status_id")
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return The actual status message
	 */
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return The entity who created the status message
	 */
	public AuthorizationEntity getCreatedBy() {
		return createdBy;
	}

	@JsonProperty("created_by")
	public void setCreatedBy(AuthorizationEntity createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return The interface through which the status was created
	 */
	public AuthorizationInterface getCreatedVia() {
		return createdVia;
	}

	@JsonProperty("created_via")
	public void setCreatedVia(AuthorizationInterface createdVia) {
		this.createdVia = createdVia;
	}

	/**
	 * @return The date and time the message was created
	 */
	public DateTime getCreatedOn() {
		return createdOn;
	}

	@JsonProperty("created_on")
	public void setCreatedOn(DateTime createdOn) {
		this.createdOn = createdOn;
	}
}
