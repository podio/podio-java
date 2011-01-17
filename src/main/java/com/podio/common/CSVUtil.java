package com.podio.common;

import java.util.Arrays;
import java.util.Collection;

public final class CSVUtil {

	private CSVUtil() {
	}

	public static String toCSV(Object... objects) {
		return toCSV(Arrays.asList(objects));
	}

	public static String toCSV(Collection<?> objects) {
		String out = "";
		for (Object object : objects) {
			if (out != "") {
				out += "; ";
			}
			out += object;
		}
		return out;
	}
}
