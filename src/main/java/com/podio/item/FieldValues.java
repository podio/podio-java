package com.podio.item;

import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class FieldValues {

	/**
	 * The id of the field
	 */
	private int fieldId;

	/**
	 * The values
	 */
	private List<FieldValue> values;

	public FieldValues() {
		super();
	}

	public FieldValues(int fieldId, List<FieldValue> values) {
		super();
		this.fieldId = fieldId;
		this.values = values;
	}

	public FieldValues(int fieldId, FieldValue value) {
		super();
		this.fieldId = fieldId;
		this.values = Collections.singletonList(value);
	}

	public FieldValues(int fieldId, String subId, String value) {
		super();
		this.fieldId = fieldId;
		this.values = Collections.singletonList(new FieldValue(subId, value));
	}

	@XmlElement(name = "field_id")
	public int getFieldId() {
		return fieldId;
	}

	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}

	@XmlElement(name = "values")
	public List<FieldValue> getValues() {
		return values;
	}

	public void setValues(List<FieldValue> values) {
		this.values = values;
	}
}
