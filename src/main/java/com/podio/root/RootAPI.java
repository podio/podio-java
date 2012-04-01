package com.podio.root;

import com.podio.BaseAPI;
import com.podio.ResourceFactory;

/**
 * Very basic API to get the status of the system.
 */
public class RootAPI extends BaseAPI {

	public RootAPI(ResourceFactory resourceFactory) {
		super(resourceFactory);
	}

	/**
	 * @return The current status of the system
	 */
	public SystemStatus getStatus() {
		return getResourceFactory().getApiResource("/", false).get(
				SystemStatus.class);
	}
}
