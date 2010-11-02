package com.podio.rating;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.namespace.QName;

public class RatingCounts {

	private Map<QName, ValueRatings> values = new HashMap<QName, ValueRatings>();

	public ValueRatings get(int value) {
		return values.get(new QName(Integer.toString(value)));
	}

	public Map<QName, ValueRatings> getValues() {
		return values;
	}

	public void setValues(Map<QName, ValueRatings> values) {
		this.values = values;
	}
}
