package com.podio.comment;

import java.util.Collections;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class CommentCreate {

	/**
	 * The comment to be made
	 */
	private String value;

	/**
	 * The external id
	 */
	private String externalId;

	/**
	 * The users who should be alerted about this comment
	 */
	private List<Integer> alerts;

	/**
	 * Temporary files that have been uploaded and should be attached to this
	 * comment
	 */
	private List<Integer> fileIds;

	public CommentCreate(String value) {
		this(value, null, Collections.<Integer> emptyList(), Collections
				.<Integer> emptyList());
	}

	public CommentCreate(String value, String externalId, List<Integer> alerts,
			List<Integer> fileIds) {
		super();
		this.value = value;
		this.externalId = externalId;
		this.alerts = alerts;
		this.fileIds = fileIds;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@JsonProperty("external_id")
	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public List<Integer> getAlerts() {
		return alerts;
	}

	public void setAlerts(List<Integer> alerts) {
		this.alerts = alerts;
	}

	@JsonProperty("file_ids")
	public List<Integer> getFileIds() {
		return fileIds;
	}

	public void setFileIds(List<Integer> fileIds) {
		this.fileIds = fileIds;
	}
}
