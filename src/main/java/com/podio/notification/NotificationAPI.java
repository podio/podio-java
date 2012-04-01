package com.podio.notification;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.joda.time.DateTime;

import com.podio.BaseAPI;
import com.podio.ResourceFactory;
import com.podio.common.CSVUtil;
import com.podio.common.Empty;
import com.podio.serialize.DateTimeUtil;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

/**
 * A notification is an information about an event that occured in Podio. A
 * notification is directed against a single user, and can have a status of
 * either unread or viewed. Notifications have a reference to the action that
 * caused the notification.
 */
public class NotificationAPI extends BaseAPI {

	public NotificationAPI(ResourceFactory resourceFactory) {
		super(resourceFactory);
	}

	/**
	 * Returns a single notification from an id. The notification will contain
	 * the bare data, but will have a reference to the object that caused the
	 * notification.
	 * 
	 * The data returned will vary based on the type of the notification. See
	 * the online documentation for details.
	 * 
	 * @param notificationId
	 *            The id of the notification
	 * @return The notification requested
	 */
	public Notification getNotification(int notificationId) {
		return getResourceFactory().getApiResource(
				"/notification/" + notificationId).get(Notification.class);
	}

	/**
	 * Returns a list of notifications that have not yet been viewed. The
	 * notifications will be sorted descending by the time of creation.
	 * 
	 * @param limit
	 *            The limit of the maximum number of notifications to return,
	 *            defaults to 10
	 * @param offset
	 *            The offset into the notifications to get, defaults to 0
	 * @return The unviewed notifications
	 */
	public List<Notification> getInboxNew(Integer limit, Integer offset,
			DateTime earliest) {
		WebResource resource = getResourceFactory().getApiResource(
				"/notification/inbox/new/");
		if (limit != null) {
			resource = resource.queryParam("limit", limit.toString());
		}
		if (offset != null) {
			resource = resource.queryParam("offset", offset.toString());
		}
		if (earliest != null) {
			resource = resource.queryParam("earliest",
					DateTimeUtil.formatDateTime(earliest));
		}

		return resource.get(new GenericType<List<Notification>>() {
		});
	}

	/**
	 * Returns the number of unread notifications
	 * 
	 * @return The number of unread notifications
	 */
	public int getInboxNewCount() {
		WebResource resource = getResourceFactory().getApiResource(
				"/notification/inbox/new/count");

		return resource.get(InboxNewCount.class).getNewNotifications();
	}

	/**
	 * Returns the notifications in the inbox that has already been viewed. The
	 * notifications are sorted in descending order, either by viewed time or
	 * creation time.
	 * 
	 * For details on the content of the individual notifications, see the
	 * online documentation.
	 * 
	 * @param limit
	 *            The limit on the number of notifications to return, default is
	 *            10 (used for paging)
	 * @param offset
	 *            The offset on the notifications to return, default is 0 (used
	 *            for paging)
	 * @param dateType
	 *            The type of date to use for sorting and filtering.
	 * @param types
	 *            The list of notifications to return
	 * @param dateFrom
	 *            The earliest date to get notifications from
	 * @param dateTo
	 *            The latest date to get notifications from
	 * @param users
	 *            A of user ids to see notifications from
	 * @param sent
	 *            <code>true</code> if sent notifications should be returned,
	 *            <code>false</code> otherwise
	 * @return The list of notifications
	 */
	public List<Notification> getInboxViewed(Integer limit, Integer offset,
			NotificationDateType dateType, Collection<NotificationType> types,
			DateTime dateFrom, DateTime dateTo, Collection<Integer> users,
			Boolean sent) {
		WebResource resource = getResourceFactory().getApiResource(
				"/notification/inbox/viewed/");
		if (limit != null) {
			resource = resource.queryParam("limit", limit.toString());
		}
		if (offset != null) {
			resource = resource.queryParam("offset", offset.toString());
		}
		if (dateType != null) {
			resource = resource.queryParam("date_type", dateType.toString());
		}
		if (types != null && !types.isEmpty()) {
			resource = resource.queryParam("types", CSVUtil.toCSV(types));
		}
		if (dateFrom != null) {
			resource = resource.queryParam("date_from",
					DateTimeUtil.formatDateTime(dateFrom));
		}
		if (dateTo != null) {
			resource = resource.queryParam("date_to",
					DateTimeUtil.formatDateTime(dateTo));
		}
		if (users != null && !users.isEmpty()) {
			resource = resource.queryParam("users", CSVUtil.toCSV(users));
		}
		if (sent != null) {
			resource = resource.queryParam("sent", sent ? "1" : "0");
		}

		return resource.get(new GenericType<List<Notification>>() {
		});
	}

	/**
	 * Mark the notification as viewed. This will move the notification from the
	 * inbox to the viewed archive.
	 * 
	 * @param notificationId
	 *            The id of the notification
	 */
	public void markAsViewed(int notificationId) {
		getResourceFactory()
				.getApiResource("/notification/" + notificationId + "/viewed")
				.entity(new Empty(), MediaType.APPLICATION_JSON_TYPE).post();
	}
}