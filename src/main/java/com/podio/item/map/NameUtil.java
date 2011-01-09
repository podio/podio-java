package com.podio.item.map;

public final class NameUtil {

	private NameUtil() {
	}

	public static String toJava(String name) {
		String out = "";
		boolean nextUpper = false;
		for (int i = 0; i < name.length(); i++) {
			char next = name.charAt(i);
			if (next == '-') {
				nextUpper = true;
			} else {
				if (nextUpper) {
					next = Character.toUpperCase(next);
				}
				out += next;
				nextUpper = false;
			}
		}

		return out;
	}

	public static String toAPI(String name) {
		String out = "";
		for (int i = 0; i < name.length(); i++) {
			char next = name.charAt(i);
			if (Character.isUpperCase(next)) {
				out += '-';
				next = Character.toLowerCase(next);
			}
			out += next;
		}

		return out;
	}
}
