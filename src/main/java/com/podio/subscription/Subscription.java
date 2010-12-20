package com.podio.subscription;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

import com.podio.common.ReferenceType;

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
	 * The type of object this subscription is on
	 */
	private ReferenceType referenceType;

	/**
	 * The id of the object this subscription is on
	 */
	private int referenceId;

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

	public ReferenceType getReferenceType() {
		return referenceType;
	}

	@JsonProperty("ref_type")
	public void setReferenceType(ReferenceType referenceType) {
		this.referenceType = referenceType;
	}

	public int getReferenceId() {
		return referenceId;
	}

	@JsonProperty("ref_id")
	public void setReferenceId(int referenceId) {
		this.referenceId = referenceId;
	}
}
