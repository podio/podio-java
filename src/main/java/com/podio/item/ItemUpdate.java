package com.podio.item;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ItemUpdate {

	/**
	 * The external id of the item. This can be used to hold a reference to the
	 * item in an external system.
	 */
	private String externalId;

	/**
	 * The internal revision from podio.
	 */
	private int revision;

	/**
	 * The values for each field
	 */
	private List<FieldValuesUpdate> fields;

	public ItemUpdate() {
		super();
	}

	public ItemUpdate(String externalId, List<FieldValuesUpdate> fields) {
		super();
		this.externalId = externalId;
		this.fields = fields;
	}

	@JsonProperty("external_id")
	public String getExternalId() {
		return externalId;
	}

	@JsonProperty("external_id")
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	
	@JsonProperty("revision")
	public int getRevision() {
		return revision;
	}

	@JsonProperty("revision")
	public void setRevision(int revision) {
		this.revision = revision;
	}

	public List<FieldValuesUpdate> getFields() {
		return fields;
	}

	public void setFields(List<FieldValuesUpdate> fields) {
		this.fields = fields;
	}

	public void addField(FieldValuesUpdate field) {
		if (this.fields == null) {
			this.fields = new ArrayList<FieldValuesUpdate>();
		}
		this.fields.add(field);
	}
}
