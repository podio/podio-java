package com.podio;

import com.podio.oauth.OAuthClientCredentials;
import com.podio.oauth.OAuthUsernameCredentials;

public class BaseAPIFactory {

	// Username and password for the test database
	// Don't bother trying it against api.podio.com, it won't work :)
	private static final BaseAPI BASE_API = new BaseAPI("localhost", 9090,
			false, true, new OAuthClientCredentials("dev@hoisthq.com",
					"CmACRWF1WBOTDfOa20A"), new OAuthUsernameCredentials(
					"dev@hoisthq.com", "AARehARgE1NFPQUv"));

	public static BaseAPI get() {
		return BASE_API;
	}
}
