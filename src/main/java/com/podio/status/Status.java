package com.podio.status;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.common.CreatedBase;

/**
 * A status message posted by a user to a space
 */
public class Status extends CreatedBase {

	private int statusId;

	private String value;

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
}
