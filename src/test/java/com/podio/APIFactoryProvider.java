package com.podio;

public final class APIFactoryProvider {

	private APIFactoryProvider() {
	}

	public static APIFactory get() {
		return new APIFactory(ResourceFactoryProvider.get());
	}

	public static APIFactory get(int userId) {
		return new APIFactory(ResourceFactoryProvider.get(userId));
	}
}
