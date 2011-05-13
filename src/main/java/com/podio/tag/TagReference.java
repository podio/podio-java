package com.podio.tag;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

import com.podio.common.ReferenceType;

public class TagReference {

	/**
	 * The type of object
	 */
	private ReferenceType type;

	/**
	 * The id of the object
	 */
	private int id;

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

	public ReferenceType getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(ReferenceType type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(int id) {
		this.id = id;
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
