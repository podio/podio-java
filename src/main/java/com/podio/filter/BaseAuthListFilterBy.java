package com.podio.filter;

import java.util.ArrayList;
import java.util.List;

import com.podio.common.CSVUtil;
import com.podio.common.Reference;

public abstract class BaseAuthListFilterBy implements FilterBy<List<Reference>> {

	@Override
	public final String format(List<Reference> values) {
		return CSVUtil.toCSV(values);
	}

	@Override
	public final List<Reference> parse(String value) {
		List<Reference> references = new ArrayList<Reference>();
		List<String> strings = FilterUtil.stringListFromCSV(value);
		for (String string : strings) {
			references.add(Reference.parse(string));
		}
		return references;
	}

}
