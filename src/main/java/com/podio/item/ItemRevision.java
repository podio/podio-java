package com.podio.item;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

import com.podio.common.AuthorizationEntity;
import com.podio.common.AuthorizationInterface;

public class ItemRevision {

	/**
	 * The revision number
	 */
	private int revision;

	/**
	 * The revision of the app at the time this item revision was made
	 */
	private int appRevision;

	/**
	 * The entity who created the revision
	 */
	private AuthorizationEntity createdBy;

	/**
	 * The interface through which the revision was created
	 */
	private AuthorizationInterface createdVia;

	/**
	 * When the revision was created
	 */
	private DateTime createdOn;

	public int getRevision() {
		return revision;
	}

	public void setRevision(int revision) {
		this.revision = revision;
	}

	@JsonProperty("app_revision")
	public int getAppRevision() {
		return appRevision;
	}

	@JsonProperty("app_revision")
	public void setAppRevision(int appRevision) {
		this.appRevision = appRevision;
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
}
