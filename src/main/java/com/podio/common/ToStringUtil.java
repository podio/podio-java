package com.podio.common;

import java.util.Collection;

public final class ToStringUtil {

	private ToStringUtil() {
	}

	public static String toString(Collection<?> objects, CharSequence delimiter) {
		StringBuilder sb = new StringBuilder();
		for (Object o : objects) {
			sb.append(o.toString());
			sb.append(delimiter);
		}
		sb.setLength(sb.length() - delimiter.length());
		return sb.toString();
	}
}
