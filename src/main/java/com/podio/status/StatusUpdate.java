package com.podio.status;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class StatusUpdate {

	private String value;

	private List<Integer> fileIds;

	public StatusUpdate() {
		super();
	}

	public StatusUpdate(String value, List<Integer> fileIds) {
		super();
		this.value = value;
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
