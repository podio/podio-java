package com.podio.filter;

public class TitleFilterBy implements FilterBy<String> {

	@Override
	public String getKey() {
		return "title";
	}

	@Override
	public String format(String value) {
		return value;
	}
}
