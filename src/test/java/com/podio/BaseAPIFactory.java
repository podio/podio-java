package com.podio;

import com.podio.oauth.OAuthClientCredentials;
import com.podio.oauth.OAuthUsernameCredentials;

public class BaseAPIFactory {

	private static final BaseAPI BASE_API = new BaseAPI("localhost", 8080,
			false, new OAuthClientCredentials("dev@hoisthq.com",
					"CmACRWF1WBOTDfOa20A"), new OAuthUsernameCredentials(
					"dev@hoisthq.com", "AARehARgE1NFPQUv"));

	public static BaseAPI get() {
		return BASE_API;
	}
}
