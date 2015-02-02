package com.podio.filter;

public class NumberFieldFilterBy extends FieldFilterBy<NumberInterval> {

	public NumberFieldFilterBy(int fieldId) {
		super(fieldId);
	}

	@Override
	public String format(NumberInterval value) {
		return value.getFrom() + "-" + value.getTo();
	}
}
