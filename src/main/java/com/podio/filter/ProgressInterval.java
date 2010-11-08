package com.podio.filter;

public final class ProgressInterval {

	private final int from;

	private final int to;

	public ProgressInterval(int from, int to) {
		super();
		this.from = from;
		this.to = to;

		if (from < 0 || from > 100) {
			throw new IllegalArgumentException("From must be between 0 and 100");
		}
		if (to < 0 || to > 100) {
			throw new IllegalArgumentException("To must be between 0 and 100");
		}
		if (to < from) {
			throw new IllegalArgumentException("To must be larger than from");
		}
	}

	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}
}
