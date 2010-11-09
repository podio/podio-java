package com.podio.user;

import java.util.Collections;
import java.util.List;

public class ProfileFieldMultiValue<F> {

	private final List<F> value;

	public ProfileFieldMultiValue(F value) {
		this(Collections.singletonList(value));
	}

	public ProfileFieldMultiValue(List<F> value) {
		super();
		this.value = value;
	}

	public List<F> getValue() {
		return value;
	}
}
