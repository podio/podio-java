package com.podio.item;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

public class FieldValuesUpdate {

	/**
	 * The id of the field
	 */
	private int id;

	/**
	 * The values
	 */
	private List<Map<String, Object>> values;

	public FieldValuesUpdate() {
		super();
	}

	public FieldValuesUpdate(int id, List<Map<String, Object>> values) {
		super();
		this.id = id;
		this.values = values;
	}

	public FieldValuesUpdate(int id, Map<String, Object> value) {
		super();
		this.id = id;
		this.values = Collections.singletonList(value);
	}

	public FieldValuesUpdate(int id, String subId, Object value) {
		super();
		this.id = id;
		this.values = Collections.singletonList(Collections.singletonMap(subId,
				value));
	}

	@JsonProperty("field_id")
	public int getId() {
		return id;
	}

	@JsonProperty("field_id")
	public void setId(int fieldId) {
		this.id = fieldId;
	}

	public List<Map<String, Object>> getValues() {
		return values;
	}

	public void setValues(List<Map<String, Object>> values) {
		this.values = values;
	}
}
