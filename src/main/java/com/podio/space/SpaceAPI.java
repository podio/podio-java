package com.podio.space;

import javax.ws.rs.core.MediaType;

import com.podio.BaseAPI;

public class SpaceAPI {

	private final BaseAPI baseAPI;

	public SpaceAPI(BaseAPI baseAPI) {
		this.baseAPI = baseAPI;
	}

	public SpaceWithOrganization getByURL(String url) {
		return baseAPI.getResource("/space/url").queryParam("url", url)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(SpaceWithOrganization.class);
	}
}
