package com.podio.filter;

public final class NumberInterval {

	private final float from;

	private final float to;

	public NumberInterval(float from, float to) {
		super();
		this.from = from;
		this.to = to;
	}

	public float getFrom() {
		return from;
	}

	public float getTo() {
		return to;
	}
}
