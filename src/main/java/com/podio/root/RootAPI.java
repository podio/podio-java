package com.podio.root;

import javax.ws.rs.core.MediaType;

import com.podio.BaseAPI;

/**
 * Very basic API to get the status of the system.
 */
public class RootAPI {

	private final BaseAPI baseAPI;

	public RootAPI(BaseAPI baseAPI) {
		this.baseAPI = baseAPI;
	}

	/**
	 * @return The current status of the system
	 */
	public SystemStatus getStatus() {
		return baseAPI.getApiResource("/", false)
				
				.get(SystemStatus.class);
	}
}
