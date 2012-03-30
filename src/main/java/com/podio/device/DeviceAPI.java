package com.podio.device;

import java.util.List;

import com.podio.BaseAPI;
import com.podio.ResourceFactory;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

/**
 * The calendar is used to get the calendar for a user. The calendar includes
 * items with a date field in the interval and tasks with a due date in the
 * interval.
 * 
 * Calendar entries are always sorted by date.
 */
public class DeviceAPI extends BaseAPI {

	public DeviceAPI(ResourceFactory resourceFactory) {
		super(resourceFactory);
	}

	public List<PushSubscription> getPushSubscriptions() {
		WebResource resource = this.getResourceFactory().getApiResource(
				"/device/push_subscriptions/");

		return resource.get(new GenericType<List<PushSubscription>>() {
		});
	}
}
