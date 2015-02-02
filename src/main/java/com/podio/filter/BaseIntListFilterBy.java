package com.podio.filter;

import java.util.List;

import com.podio.common.CSVUtil;

public abstract class BaseIntListFilterBy implements FilterBy<List<Integer>> {

	@Override
	public final String format(List<Integer> values) {
		return CSVUtil.toCSV(values);
	}
}
