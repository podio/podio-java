package com.podio.user;

import javax.ws.rs.core.MediaType;

import com.podio.BaseAPI;

public class UserAPI {

	private final BaseAPI baseAPI;

	public UserAPI(BaseAPI baseAPI) {
		this.baseAPI = baseAPI;
	}

	public UserStatus getStatus() {
		return baseAPI.getResource("/user/status")
				.accept(MediaType.APPLICATION_JSON_TYPE).get(UserStatus.class);
	}
}
