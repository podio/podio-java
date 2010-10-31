package com.podio.app;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Application extends ApplicationBase {

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

	private List<ApplicationField> fields;

	@XmlElement(name = "app_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement(name = "original")
	public Integer getOriginal() {
		return original;
	}

	public void setOriginal(Integer original) {
		this.original = original;
	}

	@XmlElement(name = "original_revision")
	public Integer getOriginalRevision() {
		return originalRevision;
	}

	public void setOriginalRevision(Integer originalRevision) {
		this.originalRevision = originalRevision;
	}

	@XmlElement(name = "space_id")
	public int getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(int spaceId) {
		this.spaceId = spaceId;
	}

	@XmlElement(name = "owner_id")
	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	@XmlElement(name = "fields")
	public List<ApplicationField> getFields() {
		return fields;
	}

	public void setFields(List<ApplicationField> fields) {
		this.fields = fields;
	}
}
