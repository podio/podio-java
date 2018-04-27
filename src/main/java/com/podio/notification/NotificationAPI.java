package com.podio.notification;

import com.podio.BaseAPI;
import com.podio.ResourceFactory;
import com.podio.common.CSVUtil;
import com.podio.common.Empty;
import com.podio.conversation.Conversation;
import com.podio.serialize.DateTimeUtil;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import org.joda.time.DateTime;

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
	 * Returns the number of unread notifications
	 * 
	 * @return The number of unread notifications
	 */
	public int getInboxNewCount() {
		WebResource resource = getResourceFactory().getApiResource(
				"/notification/inbox/new/count");

		return resource.get(InboxNewCount.class).getNewNotifications();
	}
	public List<Notification>  getUnviewedNotifications(MultivaluedMap<String,String> filters) {
		WebResource resource = getResourceFactory().getApiResource(
				"/notification/");
//                MultivaluedMap<String,String> filters=new MultivaluedMap();
                resource=resource.queryParams(filters);
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