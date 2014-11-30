package com.podio.app;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonAutoDetect()
public class Application implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * The id of the app
	 */
	private int id;

	/**
	 * The original app that this app was a copy of
	 */
	private Integer original;

	/**
	 * The revision of the original app at the time of copy
	 */
	private Integer originalRevision;

	/**
	 * The id of the space on which the app is placed
	 */
	private int spaceId;

	/**
	 * The owner of the app, which has special access to the app
	 */
	private int ownerId;

	/**
	 * The configuration of the app
	 */
	private ApplicationConfiguration configuration;

	private List<ApplicationField> fields;

	@JsonProperty("app_id")
	public int getId() {
		return id;
	}

	@JsonProperty("app_id")
	public void setId(int id) {
		this.id = id;
	}

	public Integer getOriginal() {
		return original;
	}

	public void setOriginal(Integer original) {
		this.original = original;
	}

	@JsonProperty("original_revision")
	public Integer getOriginalRevision() {
		return originalRevision;
	}

	@JsonProperty("original_revision")
	public void setOriginalRevision(Integer originalRevision) {
		this.originalRevision = originalRevision;
	}

	@JsonProperty("space_id")
	public int getSpaceId() {
		return spaceId;
	}

	@JsonProperty("space_id")
	public void setSpaceId(int spaceId) {
		this.spaceId = spaceId;
	}

	@JsonProperty("owner_id")
	public int getOwnerId() {
		return ownerId;
	}

	@JsonProperty("owner_id")
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	@JsonProperty("config")
	public ApplicationConfiguration getConfiguration() {
		return configuration;
	}

	@JsonProperty("config")
	public void setConfiguration(ApplicationConfiguration configuration) {
		this.configuration = configuration;
	}

	public List<ApplicationField> getFields() {
		return fields;
	}

	public void setFields(List<ApplicationField> fields) {
		this.fields = fields;
	}
}
