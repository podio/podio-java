package com.podio.filter;

import java.util.List;

public class AppFieldFilterBy extends FieldFilterBy<List<Integer>> {

	public AppFieldFilterBy(int fieldId) {
		super(fieldId);
	}

	@Override
	public final String format(List<Integer> values) {
		return FilterUtil.integerListToCSV(values);
	}

	@Override
	public final List<Integer> parse(String value) {
		return FilterUtil.integerListFromCSV(value);
	}
}
