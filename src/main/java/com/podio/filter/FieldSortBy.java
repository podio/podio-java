package com.podio.filter;

public class FieldSortBy implements SortBy {

	private final int fieldId;

	public FieldSortBy(int fieldId) {
		super();
		this.fieldId = fieldId;
	}

	@Override
	public String getKey() {
		return Integer.toString(fieldId);
	}
}
