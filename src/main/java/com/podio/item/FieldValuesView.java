package com.podio.item;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.app.ApplicationFieldType;

public class FieldValuesView {

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
	 * The values
	 */
	private List<Map<String, Object>> values;

	public FieldValuesView() {
		super();
	}

	@JsonProperty("field_id")
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

	public List<Map<String, Object>> getValues() {
		return values;
	}

	public void setValues(List<Map<String, Object>> values) {
		this.values = values;
	}
}
