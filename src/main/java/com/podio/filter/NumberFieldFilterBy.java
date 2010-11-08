package com.podio.filter;

public class NumberFieldFilterBy extends FieldFilterBy<NumberInterval> {

	public NumberFieldFilterBy(int fieldId) {
		super(fieldId);
	}

	@Override
	public String format(NumberInterval value) {
		return value.getFrom() + "-" + value.getTo();
	}

	@Override
	public NumberInterval parse(String value) {
		String[] split = value.split("-");

		return new NumberInterval(Float.parseFloat(split[0]),
				Float.parseFloat(split[1]));
	}
}
