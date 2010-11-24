package com.podio.tag;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

import com.podio.common.ReferenceType;

public class TagReference {

	/**
	 * The type of object
	 */
	private ReferenceType referenceType;

	/**
	 * The id of the object
	 */
	private int referenceId;

	/**
	 * The title of the object
	 */
	private String title;

	/**
	 * When the object was created
	 */
	private DateTime createdOn;

	/**
	 * The link to the object
	 */
	private String link;

	public ReferenceType getReferenceType() {
		return referenceType;
	}

	@JsonProperty("ref_type")
	public void setReferenceType(ReferenceType referenceType) {
		this.referenceType = referenceType;
	}

	public int getReferenceId() {
		return referenceId;
	}

	@JsonProperty("ref_id")
	public void setReferenceId(int referenceId) {
		this.referenceId = referenceId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public DateTime getCreatedOn() {
		return createdOn;
	}

	@JsonProperty("created_on")
	public void setCreatedOn(DateTime createdOn) {
		this.createdOn = createdOn;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
