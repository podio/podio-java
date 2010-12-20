package com.podio.root;

import com.podio.ResourceFactory;

/**
 * Very basic API to get the status of the system.
 */
public class RootAPI {

	private final ResourceFactory resourceFactory;

	public RootAPI(ResourceFactory resourceFactory) {
		this.resourceFactory = resourceFactory;
	}

	/**
	 * @return The current status of the system
	 */
	public SystemStatus getStatus() {
		return resourceFactory.getApiResource("/", false).get(
				SystemStatus.class);
	}
}
