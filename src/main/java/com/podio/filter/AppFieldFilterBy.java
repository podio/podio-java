package com.podio.filter;

import java.util.List;

import com.podio.common.CSVUtil;

public class AppFieldFilterBy extends FieldFilterBy<List<Integer>> {

	public AppFieldFilterBy(int fieldId) {
		super(fieldId);
	}

	@Override
	public final String format(List<Integer> values) {
		return CSVUtil.toCSV(values);
	}
}
