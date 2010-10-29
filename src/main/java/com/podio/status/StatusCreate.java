package com.podio.status;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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

	@XmlElement(name = "space_id")
	public int getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(int spaceId) {
		this.spaceId = spaceId;
	}

	@XmlElement(name = "value")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@XmlElement(name = "alerts")
	public List<Integer> getAlerts() {
		return alerts;
	}

	public void setAlerts(List<Integer> alerts) {
		this.alerts = alerts;
	}

	@XmlElement(name = "file_ids")
	public List<Integer> getFileIds() {
		return fileIds;
	}

	public void setFileIds(List<Integer> fileIds) {
		this.fileIds = fileIds;
	}

}
