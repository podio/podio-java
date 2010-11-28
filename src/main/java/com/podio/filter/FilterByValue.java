package com.podio.filter;

public class FilterByValue<T> {

	private final FilterBy<T> by;

	private final T value;

	public FilterByValue(FilterBy<T> by, T value) {
		super();
		this.by = by;
		this.value = value;
	}

	public FilterBy<T> getBy() {
		return by;
	}

	public T getValue() {
		return value;
	}

	public String getFormattedValue() {
		return by.format(value);
	}
}
