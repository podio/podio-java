package com.podio.comment;

import java.util.Collections;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class CommentUpdate {

	/**
	 * The comment to be made
	 */
	private String value;

	/**
	 * The external id of the comment
	 */
	private String externalId;

	/**
	 * Temporary files that have been uploaded and should be attached to this
	 * comment
	 */
	private List<Integer> fileIds;

	public CommentUpdate(String value) {
		this(value, Collections.<Integer> emptyList());
	}

	public CommentUpdate(String value, List<Integer> fileIds) {
		super();
		this.value = value;
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

	@JsonProperty("file_ids")
	public List<Integer> getFileIds() {
		return fileIds;
	}

	public void setFileIds(List<Integer> fileIds) {
		this.fileIds = fileIds;
	}
}
