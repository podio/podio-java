package com.podio.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class FilterUtil {

	private FilterUtil() {
	}

	public static String integerListToCSV(List<Integer> values) {
		String out = "";
		for (Integer value : values) {
			if (out.length() > 0) {
				out += ",";
			}
			out += value;
		}
		return out;
	}

	public static List<Integer> integerListFromCSV(String value) {
		List<Integer> values = new ArrayList<Integer>();
		for (String strValue : value.split(",")) {
			values.add(Integer.parseInt(strValue));
		}
		return values;
	}

	public static String stringListToCSV(List<String> values) {
		String out = "";
		for (String value : values) {
			if (out.length() > 0) {
				out += ",";
			}
			out += value;
		}
		return out;
	}

	public static List<String> stringListFromCSV(String value) {
		return Arrays.asList(value.split(","));
	}
}
