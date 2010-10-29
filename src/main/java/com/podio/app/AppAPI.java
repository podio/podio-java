package com.podio.app;

import javax.ws.rs.core.MediaType;

import com.podio.BaseAPI;

public class AppAPI {

	private final BaseAPI baseAPI;

	public AppAPI(BaseAPI baseAPI) {
		this.baseAPI = baseAPI;
	}

	public Application getApp(int appId) {
		return baseAPI.getResource("/app/" + appId)
				.accept(MediaType.APPLICATION_JSON_TYPE).get(Application.class);
	}
}
