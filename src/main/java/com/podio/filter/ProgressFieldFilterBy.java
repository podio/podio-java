package com.podio.filter;

public class ProgressFieldFilterBy extends FieldFilterBy<ProgressInterval> {

	public ProgressFieldFilterBy(int fieldId) {
		super(fieldId);
	}

	@Override
	public String format(ProgressInterval value) {
		return value.getFrom() + "-" + value.getTo();
	}
}
