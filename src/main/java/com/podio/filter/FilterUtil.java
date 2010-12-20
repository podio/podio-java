package com.podio.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class FilterUtil {

	private FilterUtil() {
	}

	public static List<Integer> integerListFromCSV(String value) {
		List<Integer> values = new ArrayList<Integer>();
		for (String strValue : value.split(",")) {
			values.add(Integer.parseInt(strValue));
		}
		return values;
	}

	public static List<String> stringListFromCSV(String value) {
		return Arrays.asList(value.split(","));
	}
}
