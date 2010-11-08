package com.podio.filter;

public class ProgressFieldFilterBy extends FieldFilterBy<ProgressInterval> {

	public ProgressFieldFilterBy(int fieldId) {
		super(fieldId);
	}

	@Override
	public String format(ProgressInterval value) {
		return value.getFrom() + "-" + value.getTo();
	}

	@Override
	public ProgressInterval parse(String value) {
		String[] split = value.split("-");

		return new ProgressInterval(Integer.parseInt(split[0]),
				Integer.parseInt(split[1]));
	}
}
