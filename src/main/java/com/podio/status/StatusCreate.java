package com.podio.status;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class StatusCreate {

	private String value;

	private List<Integer> alerts;

	private List<Integer> fileIds;

	public StatusCreate() {
		super();
	}

	public StatusCreate(String value, List<Integer> alerts,
			List<Integer> fileIds) {
		super();
		this.value = value;
		this.alerts = alerts;
		this.fileIds = fileIds;
	}

	public String getValue() {
		return value;
	}

	/**
	 * Sets the text value of the status message
	 * 
	 * @param value
	 *            The text of the status
	 */
	public void setValue(String value) {
		this.value = value;
	}

	public List<Integer> getAlerts() {
		return alerts;
	}

	/**
	 * Sets the list of users to alert in this status updated
	 * 
	 * @param alerts
	 *            The ids of the users to alert
	 */
	public void setAlerts(List<Integer> alerts) {
		this.alerts = alerts;
	}

	@JsonProperty("file_ids")
	public List<Integer> getFileIds() {
		return fileIds;
	}

	/**
	 * Sets the files to attach to this status message
	 * 
	 * @param fileIds
	 *            The id of the files already uploaded that should be attached
	 *            to this status
	 */
	public void setFileIds(List<Integer> fileIds) {
		this.fileIds = fileIds;
	}

}
