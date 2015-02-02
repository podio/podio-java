package com.podio.filter;

public class ExternalIdFilterBy implements FilterBy<String> {

	@Override
	public String getKey() {
		return "external_id";
	}

	@Override
	public String format(String value) {
		return value;
	}
}
