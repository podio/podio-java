package com.podio.item;

import java.util.Collections;
import java.util.Map;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;

@XmlRootElement
public class FieldValue {

	private Map<QName, Object> values;

	public FieldValue() {
		super();
	}

	public FieldValue(String subId, Object value) {
		super();
		this.values = Collections.<QName, Object> singletonMap(
				new QName(subId), value);
	}

	public FieldValue(Map<QName, Object> values) {
		super();
		this.values = values;
	}

	public Object getValue(String subId) {
		return values.get(new QName(subId));
	}

	@XmlAnyAttribute
	public Map<QName, Object> getValues() {
		return values;
	}

	public void setValues(Map<QName, Object> values) {
		this.values = values;
	}
}
