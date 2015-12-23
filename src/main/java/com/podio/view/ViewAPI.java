package com.podio.view;

import java.util.List;

import com.podio.BaseAPI;
import com.podio.ResourceFactory;
import com.sun.jersey.api.client.GenericType;

public class ViewAPI extends BaseAPI{
	public ViewAPI(ResourceFactory resourceFactory) {
		super(resourceFactory);
	}
	
	/**
	 * returns the views for the given app
	 * 
	 * @param appId
	 * 			the id of the app
	 * @return The list of views of the given app
	 */
	public List<View> getViews(int appId) {
		return getResourceFactory().getApiResource("/view/app/" + appId ).get(
				new GenericType<List<View>>() {
				});
	}

}
