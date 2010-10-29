package com.podio.status;

import com.podio.BaseAPI;
import com.podio.oauth.OAuthClientCredentials;
import com.podio.oauth.OAuthUsernameCredentials;

public class StatusPoster {

	public static void main(String[] args) {
		BaseAPI baseAPI = new BaseAPI("api.nextpodio.dk", 443, true,
				new OAuthClientCredentials("dev@podio.com", "secretstuff"),
				new OAuthUsernameCredentials("holm@podio.com", "secretstuff"));

		StatusAPI statusAPI = new StatusAPI(baseAPI);
		statusAPI.createStatus(new StatusCreate(207, "Hello from Java", null,
				null));
	}
}
