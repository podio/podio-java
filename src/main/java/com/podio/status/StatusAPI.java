package com.podio.status;

import javax.ws.rs.core.MediaType;

import com.podio.BaseAPI;

public class StatusAPI {

	private final BaseAPI baseAPI;

	public StatusAPI(BaseAPI baseAPI) {
		this.baseAPI = baseAPI;
	}

	public StatusCreateResponse createStatus(StatusCreate status) {
		return baseAPI.getApiResource("/status/")
				.entity(status, MediaType.APPLICATION_JSON_TYPE)
				.post(StatusCreateResponse.class);
	}
}
