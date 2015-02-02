package com.podio.filter;

import org.joda.time.LocalDate;

public class PodioDateInterval {
	
	private final PodioDate fromDate;
	
	private final PodioDate toDate;

	public PodioDateInterval(PodioDate fromDate, PodioDate toDate) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	
	public String serialize() {
		String result = "";
		if (fromDate != null) {
			result += fromDate.serialize();
		}
		result += "-";
		if (toDate != null) {
			result += toDate.serialize();
		}
		return result;
	}
	
	public static final PodioDateInterval absolute(LocalDate fromDate, LocalDate toDate) {
		return new PodioDateInterval(new AbsolutePodioDate(fromDate), new AbsolutePodioDate(toDate));
	}

}
