package com.podio.serialize;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public final class DateTimeUtil {

	private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormat
			.forPattern("yyyy-MM-dd HH:mm:ss");

	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormat
			.forPattern("yyyy-MM-dd");

	private DateTimeUtil() {
	}

	public static DateTime parseDateTime(String text) {
		return DATE_TIME_FORMAT.parseDateTime(text);
	}

	public static String formatDateTime(DateTime dateTime) {
		return DATE_TIME_FORMAT.print(dateTime);
	}

	public static LocalDate parseDate(String text) {
		return DATE_FORMAT.parseDateTime(text).toLocalDate();
	}

	public static String formatDate(LocalDate date) {
		return DATE_FORMAT.print(date);
	}
}
