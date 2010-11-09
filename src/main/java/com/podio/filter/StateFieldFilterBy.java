package com.podio.filter;

import java.util.List;

public class StateFieldFilterBy extends FieldFilterBy<List<String>> {

	public StateFieldFilterBy(int fieldId) {
		super(fieldId);
	}

	@Override
	public String format(List<String> values) {
		return FilterUtil.stringListToCSV(values);
	}

	@Override
	public List<String> parse(String value) {
		return FilterUtil.stringListFromCSV(value);
	}
}
