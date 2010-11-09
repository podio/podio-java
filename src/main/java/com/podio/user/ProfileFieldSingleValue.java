package com.podio.user;

public class ProfileFieldSingleValue<F> {

	private final F value;

	public ProfileFieldSingleValue(F value) {
		super();
		this.value = value;
	}

	public F getValue() {
		return value;
	}
}
