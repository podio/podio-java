package com.podio;

public final class APIFactoryProvider {

	private APIFactoryProvider() {
	}

	public static APIFactory getDefault() {
		return new APIFactory(ResourceFactoryProvider.getDefault());
	}

	public static APIFactory get(int userId) {
		return new APIFactory(ResourceFactoryProvider.getUser(userId));
	}

	public static APIFactory getApp(int appId) {
		return new APIFactory(ResourceFactoryProvider.getApp(appId));
	}

	public static APIFactory getCode(String code) {
		return new APIFactory(ResourceFactoryProvider.getCode(code));
	}
}
