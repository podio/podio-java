package com.podio;

import java.util.HashMap;
import java.util.Map;

import com.podio.oauth.OAuthAppCredentials;
import com.podio.oauth.OAuthClientCredentials;
import com.podio.oauth.OAuthUserCredentials;
import com.podio.oauth.OAuthUsernameCredentials;

public final class ResourceFactoryProvider {

	private static final OAuthClientCredentials CLIENT_CREDENTIALS = new OAuthClientCredentials(
			"dev@hoisthq.com", "CmACRWF1WBOTDfOa20A");

	// Username and password for the test database
	// Don't bother trying it against api.podio.com, it won't work :)
	private static final Map<Integer, OAuthUserCredentials> USER_CREDENTIALS_MAP = new HashMap<Integer, OAuthUserCredentials>();
	static {
		USER_CREDENTIALS_MAP.put(1, new OAuthUsernameCredentials(
				"dev@hoisthq.com", "AARehARgE1NFPQUv"));
		USER_CREDENTIALS_MAP.put(2, new OAuthUsernameCredentials(
				"haugstrup@hoisthq.com", "bar"));
	}

	private static final Map<Integer, ResourceFactory> USER_API_MAP = new HashMap<Integer, ResourceFactory>();

	private static final Map<Integer, OAuthUserCredentials> APP_CREDENTIALS_MAP = new HashMap<Integer, OAuthUserCredentials>();
	static {
		APP_CREDENTIALS_MAP
				.put(1,
						new OAuthAppCredentials(
								1,
								"fe8ba3bfd25402a286d4ecb42335387e01bbdcb6d836d1b3eb122737c7b75e7efdc176fafaff5ff51349fdce3a7df73efba0901943307549cade9f835208dcd0"));
	}

	private static final Map<Integer, ResourceFactory> APP_API_MAP = new HashMap<Integer, ResourceFactory>();

	private ResourceFactoryProvider() {
	}

	public static ResourceFactory getUser(int userId) {
		ResourceFactory api = USER_API_MAP.get(userId);
		if (api != null) {
			return api;
		}

		api = new ResourceFactory("localhost", "localhost", 8082, false, true,
				CLIENT_CREDENTIALS, USER_CREDENTIALS_MAP.get(userId));

		USER_API_MAP.put(userId, api);

		return api;
	}

	public static ResourceFactory getApp(int appId) {
		ResourceFactory api = APP_API_MAP.get(appId);
		if (api != null) {
			return api;
		}

		api = new ResourceFactory("localhost", "localhost", 8082, false, true,
				CLIENT_CREDENTIALS, APP_CREDENTIALS_MAP.get(appId));

		APP_API_MAP.put(appId, api);

		return api;
	}

	public static ResourceFactory getDefault() {
		return getUser(1);
	}
}
