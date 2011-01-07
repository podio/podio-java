package com.podio.item;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

public class FieldValuesUpdate {

	/**
	 * The id of the field
	 */
	private Integer id;

	/**
	 * The external id of the field
	 */
	private String externalId;

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

	public FieldValuesUpdate(String externalId, List<Map<String, Object>> values) {
		super();
		this.externalId = externalId;
		this.values = values;
	}

	public FieldValuesUpdate(String externalId, Map<String, Object> value) {
		super();
		this.externalId = externalId;
		this.values = Collections.singletonList(value);
	}

	public FieldValuesUpdate(String externalId, String subId, Object value) {
		super();
		this.externalId = externalId;
		this.values = Collections.singletonList(Collections.singletonMap(subId,
				value));
	}

	@JsonProperty("field_id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("field_id")
	public void setId(Integer fieldId) {
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

	public List<Map<String, Object>> getValues() {
		return values;
	}

	public void setValues(List<Map<String, Object>> values) {
		this.values = values;
	}
}
