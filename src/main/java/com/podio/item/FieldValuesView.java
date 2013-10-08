package com.podio.item;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.app.ApplicationFieldType;

public class FieldValuesView implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * The id of the field
	 */
	private int id;

	/**
	 * The external id of the field
	 */
	private String externalId;

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
	private List<Map<String, ?>> values;

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

	@JsonProperty("external_id")
	public String getExternalId() {
		return externalId;
	}

	@JsonProperty("external_id")
	public void setExternalId(String externalId) {
		this.externalId = externalId;
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

	public List<Map<String, ?>> getValues() {
		return values;
	}

	public void setValues(List<Map<String, ?>> values) {
		this.values = values;
	}
}
