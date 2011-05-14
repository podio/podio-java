package com.podio.notification;

import java.util.HashMap;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

import com.podio.common.CreatedBase;
import com.podio.contact.ProfileMini;
import com.podio.org.OrganizationMini;
import com.podio.space.SpaceMini;

public class Notification extends CreatedBase {

	/**
	 * The id of the notification
	 */
	private int id;

	/**
	 * The target of the notification
	 */
	private ProfileMini user;

	/**
	 * The type of the notification
	 */
	private NotificationType type;

	/**
	 * When the notification was last viewed
	 */
	private DateTime viewedOn;

	/**
	 * The id of the subscription this notification came from
	 */
	private Integer subscriptionId;

	/**
	 * The space where the notification comes from, if any,
	 */
	private SpaceMini space;

	/**
	 * The organization where the notification comes from, if any,
	 */
	private OrganizationMini organization;

	/**
	 * The link to the data, if any
	 */
	private String dataLink;

	/**
	 * The data of the notification, see the area for details
	 */
	private HashMap<String, Object> data;

	/**
	 * The type of the context
	 */
	private NotificationContextType contextType;

	/**
	 * The link to the context, if any
	 */
	private String contextLink;

	/**
	 * The context of the notification. This depends on the type above, see the
	 * area for details
	 */
	private HashMap<String, Object> context;

	public int getId() {
		return id;
	}

	@JsonProperty("notification_id")
	public void setId(int id) {
		this.id = id;
	}

	public ProfileMini getUser() {
		return user;
	}

	public void setUser(ProfileMini user) {
		this.user = user;
	}

	public NotificationType getType() {
		return type;
	}

	public void setType(NotificationType type) {
		this.type = type;
	}

	public DateTime getViewedOn() {
		return viewedOn;
	}

	@JsonProperty("viewed_on")
	public void setViewedOn(DateTime viewedOn) {
		this.viewedOn = viewedOn;
	}

	public Integer getSubscriptionId() {
		return subscriptionId;
	}

	@JsonProperty("subscription_id")
	public void setSubscriptionId(Integer subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public SpaceMini getSpace() {
		return space;
	}

	public void setSpace(SpaceMini space) {
		this.space = space;
	}

	public OrganizationMini getOrganization() {
		return organization;
	}

	@JsonProperty("org")
	public void setOrganization(OrganizationMini organization) {
		this.organization = organization;
	}

	public HashMap<String, Object> getData() {
		return data;
	}

	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}

	public String getDataLink() {
		return dataLink;
	}

	@JsonProperty("data_link")
	public void setDataLink(String dataLink) {
		this.dataLink = dataLink;
	}

	public String getContextLink() {
		return contextLink;
	}

	@JsonProperty("context_link")
	public void setContextLink(String contextLink) {
		this.contextLink = contextLink;
	}

	public NotificationContextType getContextType() {
		return contextType;
	}

	@JsonProperty("context_type")
	public void setContextType(NotificationContextType contextType) {
		this.contextType = contextType;
	}

	public HashMap<String, Object> getContext() {
		return context;
	}

	public void setContext(HashMap<String, Object> context) {
		this.context = context;
	}
}
