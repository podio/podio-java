package com.podio.filter;

public enum StandardSortBy implements SortBy {

	LAST_EDIT_ON,
	CREATED_ON,
	FIVESTAR;

	@Override
	public String getKey() {
		return name().toLowerCase();
	}
}
