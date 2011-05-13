package com.podio.subscription;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

import com.podio.common.Reference;

public class Subscription {

	/**
	 * When the subscription started
	 */
	private DateTime startedOn;

	/**
	 * The number of notifications created on this subscription
	 */
	private int notifications;

	/**
	 * The object this subscription is on
	 */
	private Reference reference;

	public DateTime getStartedOn() {
		return startedOn;
	}

	@JsonProperty("started_on")
	public void setStartedOn(DateTime startedOn) {
		this.startedOn = startedOn;
	}

	public int getNotifications() {
		return notifications;
	}

	public void setNotifications(int notifications) {
		this.notifications = notifications;
	}

	@JsonProperty("ref")
	public Reference getReference() {
		return reference;
	}

	@JsonProperty("ref")
	public void setReference(Reference reference) {
		this.reference = reference;
	}
}
