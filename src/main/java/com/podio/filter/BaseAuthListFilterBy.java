package com.podio.filter;

import java.util.List;

import com.podio.common.CSVUtil;
import com.podio.common.Reference;

public abstract class BaseAuthListFilterBy implements FilterBy<List<Reference>> {

	@Override
	public final String format(List<Reference> values) {
		return CSVUtil.toCSV(values);
	}

}
