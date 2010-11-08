package com.podio.filter;

public abstract class FieldFilterBy<T> implements FilterBy<T> {

	private final int fieldId;

	public FieldFilterBy(int fieldId) {
		super();
		this.fieldId = fieldId;
	}

	@Override
	public final String getKey() {
		return Integer.toString(fieldId);
	}
}
