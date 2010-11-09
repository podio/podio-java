package com.podio.filter;

import java.util.List;

public abstract class BaseIntListFilterBy implements FilterBy<List<Integer>> {

	@Override
	public final String format(List<Integer> values) {
		return FilterUtil.integerListToCSV(values);
	}

	@Override
	public final List<Integer> parse(String value) {
		return FilterUtil.integerListFromCSV(value);
	}
}
