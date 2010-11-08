package com.podio.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterUtil {

	private FilterUtil() {
	}

	public static String toCSV(List<Integer> values) {
		String out = "";
		for (Integer value : values) {
			if (out.length() > 0) {
				out += ",";
			}
			out += value;
		}
		return out;
	}

	public static List<Integer> fromCSV(String value) {
		List<Integer> values = new ArrayList<Integer>();
		for (String strValue : value.split(",")) {
			values.add(Integer.parseInt(strValue));
		}
		return values;
	}
}
