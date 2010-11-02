package com.podio.root;

import javax.ws.rs.core.MediaType;

import com.podio.BaseAPI;

public class RootAPI {

	private final BaseAPI baseAPI;

	public RootAPI(BaseAPI baseAPI) {
		this.baseAPI = baseAPI;
	}

	public SystemStatus getStatus() {
		return baseAPI.getResource("/", false)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(SystemStatus.class);
	}
}
