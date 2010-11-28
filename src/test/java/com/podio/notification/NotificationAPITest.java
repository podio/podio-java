package com.podio.notification;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Assert;
import org.junit.Test;

import com.podio.BaseAPIFactory;

public class NotificationAPITest {

	private NotificationAPI getAPI() {
		return new NotificationAPI(BaseAPIFactory.get());
	}

	@Test
	public void getNotification() {
		Notification notification = getAPI().getNotification(2);

		Assert.assertEquals(notification.getId(), 2);
		Assert.assertEquals(notification.getContextLink(),
				"https://hoist.podio.com/api/item/1");
		Assert.assertEquals(notification.getContext().get("external_id"),
				"Foo generator");
		Assert.assertEquals(notification.getContextType(),
				NotificationContextType.ITEM);
		Assert.assertEquals(notification.getDataLink(),
				"https://hoist.podio.com/api/item/1#comment-2");
		Assert.assertEquals(notification.getCreatedBy().getId(), 2);
		Assert.assertEquals(notification.getCreatedOn(), new DateTime(2010, 8,
				5, 9, 9, 0, 0, DateTimeZone.UTC));
		// FIXME: Change the return on notifications
		// Assert.assertEquals(notification.getOrganization().getId(), 1);
		// Assert.assertEquals(notification.getSpace().getId(), 1);
		Assert.assertEquals(notification.getSubscriptionId(), null);
		Assert.assertEquals(notification.getType(), NotificationType.ALERT);
		Assert.assertEquals(notification.getUser().getId(), 1);
		Assert.assertEquals(notification.getViewedOn(), new DateTime(2010, 8,
				5, 12, 1, 0, 0, DateTimeZone.UTC));
	}
}
