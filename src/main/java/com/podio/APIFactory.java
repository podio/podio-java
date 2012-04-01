package com.podio;

import java.lang.reflect.InvocationTargetException;

/**
 * Factory to make it simple to get a specific API to work with
 */
public class APIFactory {

	private final ResourceFactory resourceFactory;

	public APIFactory(ResourceFactory resourceFactory) {
		super();
		this.resourceFactory = resourceFactory;
	}

	public <T extends BaseAPI> T getAPI(Class<T> apiClass) {
		try {
			return apiClass.getConstructor(ResourceFactory.class).newInstance(
					this.resourceFactory);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
	}
}
