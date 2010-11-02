package com.podio.item;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

public class FieldValues {

	/**
	 * The id of the field
	 */
	private int fieldId;

	/**
	 * The values
	 */
	private List<Map<String, Object>> values;

	public FieldValues() {
		super();
	}

	public FieldValues(int fieldId, List<Map<String, Object>> values) {
		super();
		this.fieldId = fieldId;
		this.values = values;
	}

	public FieldValues(int fieldId, Map<String, Object> value) {
		super();
		this.fieldId = fieldId;
		this.values = Collections.singletonList(value);
	}

	public FieldValues(int fieldId, String subId, Object value) {
		super();
		this.fieldId = fieldId;
		this.values = Collections.singletonList(Collections.singletonMap(subId,
				value));
	}

	@JsonProperty("field_id")
	public int getFieldId() {
		return fieldId;
	}

	@JsonProperty("field_id")
	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}

	public List<Map<String, Object>> getValues() {
		return values;
	}

	public void setValues(List<Map<String, Object>> values) {
		this.values = values;
	}
}
