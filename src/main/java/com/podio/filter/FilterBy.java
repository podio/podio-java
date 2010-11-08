package com.podio.filter;

public interface FilterBy<T> {

	String getKey();

	String format(T value);

	T parse(String value);
}
