package com.podio.subscription;

import javax.ws.rs.core.MediaType;

import com.podio.BaseAPI;
import com.podio.ResourceFactory;
import com.podio.common.Empty;
import com.podio.common.Reference;

/**
 * Subscriptions allows the user to be notified when an object is created,
 * updated, delete, comments added to it or rated.
 */
public class SubscriptionAPI extends BaseAPI {

	public SubscriptionAPI(ResourceFactory resourceFactory) {
		super(resourceFactory);
	}

	/**
	 * Returns the subscription with the given id
	 * 
	 * @param susbcriptionId
	 *            The id of the subscription
	 * @return The subscription
	 */
	public Subscription getSubscription(int susbcriptionId) {
		return getResourceFactory().getApiResource(
				"/subscription/" + susbcriptionId).get(Subscription.class);
	}

	/**
	 * Get the subscription for the given object
	 * 
	 * @param reference
	 *            The reference to object
	 * @return The subscription on the object
	 */
	public Subscription getSubscription(Reference reference) {
		return getResourceFactory().getApiResource(
				"/subscription/" + reference.toURLFragment(false)).get(
				Subscription.class);
	}

	/**
	 * Subscribes the user to the given object. Based on the object type, the
	 * user will receive notifications when actions are performed on the object.
	 * See the area for more details.
	 * 
	 * @param reference
	 *            The reference to the object to subscribe to
	 */
	public void subscribe(Reference reference) {
		getResourceFactory()
				.getApiResource(
						"/subscription/" + reference.toURLFragment(false))
				.entity(new Empty(), MediaType.APPLICATION_JSON_TYPE).post();
	}

	/**
	 * Stops the subscription with the given id
	 * 
	 * @param subscriptionId
	 *            The id of the subscription
	 */
	public void unsubscribe(int subscriptionId) {
		getResourceFactory().getApiResource("/subscription/" + subscriptionId)
				.delete();
	}

	/**
	 * Unsubscribe from getting notifications on actions on the given object.
	 * 
	 * @param reference
	 *            The reference to the object
	 */
	public void unsubscribe(Reference reference) {
		getResourceFactory().getApiResource(
				"/subscription/" + reference.toURLFragment(false)).delete();
	}
}
