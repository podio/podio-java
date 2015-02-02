package com.podio.filter;

import org.joda.time.LocalDate;

public class AbsolutePodioDate implements PodioDate {

	private final LocalDate date;
	
	public AbsolutePodioDate(LocalDate date) {
		super();
		this.date = date;
	}

	@Override
	public String serialize() {
		return this.date.toString("yyyy-MM-dd");
	}

}
