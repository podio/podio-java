package com.podio.filter;

public class DateFieldFilterBy extends BaseDateFilterBy {
	
	private final int fieldId;

	public DateFieldFilterBy(int fieldId) {
		super();
		this.fieldId = fieldId;
	}

	@Override
	public final String getKey() {
		return Integer.toString(fieldId);
	}

}
