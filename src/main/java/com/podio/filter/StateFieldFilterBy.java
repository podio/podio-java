package com.podio.filter;

import java.util.Arrays;
import java.util.List;

public class StateFieldFilterBy extends FieldFilterBy<List<String>> {

	public StateFieldFilterBy(int fieldId) {
		super(fieldId);
	}

	@Override
	public String format(List<String> values) {
		String out = "";
		for (String value : values) {
			if (out.length() > 0) {
				out += ",";
			}
			out += value;
		}
		return out;
	}

	@Override
	public List<String> parse(String value) {
		return Arrays.asList(value.split(","));
	}
}
