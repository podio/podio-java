package com.podio.filter;

import java.util.List;

import com.podio.common.CSVUtil;

public class MemberFieldFilterBy extends FieldFilterBy<List<Integer>> {

	public MemberFieldFilterBy(int fieldId) {
		super(fieldId);
	}

	@Override
	public final String format(List<Integer> values) {
		return CSVUtil.toCSV(values);
	}
}
