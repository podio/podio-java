package com.podio;

public abstract class BaseAPI {

	private final ResourceFactory resourceFactory;

	public BaseAPI(ResourceFactory resourceFactory) {
		this.resourceFactory = resourceFactory;
	}

	protected ResourceFactory getResourceFactory() {
		return resourceFactory;
	}
}
