package com.podio.comment;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

import com.podio.common.AuthorizationEntity;
import com.podio.common.AuthorizationInterface;
import com.podio.contact.ProfileMini;
import com.podio.file.File;

public class Comment {

	/**
	 * The id of the comment. Can be used to update and delete the comment
	 */
	private int id;

	/**
	 * The actual comment
	 */
	private String value;

	/**
	 * The external id set on the comment
	 */
	private String externalId;

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

	/**
	 * The alerts on the comment
	 */
	private List<ProfileMini> alerts;

	/**
	 * The files on the comment
	 */
	private List<File> files;

	@JsonProperty("comment_id")
	public int getId() {
		return id;
	}

	@JsonProperty("comment_id")
	public void setId(int id) {
		this.id = id;
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

	@JsonProperty("external_id")
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public AuthorizationEntity getCreatedBy() {
		return createdBy;
	}

	@JsonProperty("created_by")
	public void setCreatedBy(AuthorizationEntity createdBy) {
		this.createdBy = createdBy;
	}

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

	public List<ProfileMini> getAlerts() {
		return alerts;
	}

	public void setAlerts(List<ProfileMini> alerts) {
		this.alerts = alerts;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}
}
