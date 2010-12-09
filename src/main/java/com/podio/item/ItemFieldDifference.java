package com.podio.item;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.app.ApplicationFieldType;

public class ItemFieldDifference {

	/**
	 * The id of the field
	 */
	private int id;

	/**
	 * The type of the field
	 */
	private ApplicationFieldType type;

	/**
	 * The label of the field
	 */
	private String label;

	/**
	 * The values at the from revision
	 */
	private List<Map<String, Object>> from;

	/**
	 * The values at the to revsion
	 */
	private List<Map<String, Object>> to;

	public int getId() {
		return id;
	}

	@JsonProperty("field_id")
	public void setId(int fieldId) {
		this.id = fieldId;
	}

	public ApplicationFieldType getType() {
		return type;
	}

	public void setType(ApplicationFieldType type) {
		this.type = type;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Map<String, Object>> getFrom() {
		return from;
	}

	public void setFrom(List<Map<String, Object>> from) {
		this.from = from;
	}

	public List<Map<String, Object>> getTo() {
		return to;
	}

	public void setTo(List<Map<String, Object>> to) {
		this.to = to;
	}
}
