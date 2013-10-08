package com.podio.item;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.common.CreatedBase;

public class ItemRevision extends CreatedBase {

	private static final long serialVersionUID = 1L;

	/**
	 * The revision number
	 */
	private int revision;

	/**
	 * The revision of the app at the time this item revision was made
	 */
	private int appRevision;

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
}
