package com.podio.status;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class StatusCreate {

	private int spaceId;

	private String value;

	private List<Integer> alerts;

	private List<Integer> fileIds;

	public StatusCreate() {
		super();
	}

	public StatusCreate(int spaceId, String value, List<Integer> alerts,
			List<Integer> fileIds) {
		super();
		this.spaceId = spaceId;
		this.value = value;
		this.alerts = alerts;
		this.fileIds = fileIds;
	}

	@JsonProperty("space_id")
	public int getSpaceId() {
		return spaceId;
	}

	@JsonProperty("space_id")
	public void setSpaceId(int spaceId) {
		this.spaceId = spaceId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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

	@JsonProperty("file_ids")
	public void setFileIds(List<Integer> fileIds) {
		this.fileIds = fileIds;
	}

}
