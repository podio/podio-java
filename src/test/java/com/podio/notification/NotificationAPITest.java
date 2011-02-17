package com.podio.notification;

import java.util.Collections;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Assert;
import org.junit.Test;

import com.podio.ResourceFactoryProvider;

public class NotificationAPITest {

	private NotificationAPI getAPI() {
		return new NotificationAPI(ResourceFactoryProvider.getDefault());
	}

	@Test
	public void getNotification() {
		Notification notification = getAPI().getNotification(2);

		Assert.assertEquals(notification.getId(), 2);
		Assert.assertEquals(notification.getContextLink(),
				"https://hoist.podio.com/api/item/1");
		Assert.assertEquals(notification.getContext().get("external_id"), "12");
		Assert.assertEquals(notification.getContextType(),
				NotificationContextType.ITEM);
		Assert.assertEquals(notification.getDataLink(),
				"https://hoist.podio.com/api/item/1#comment-2");
		Assert.assertEquals(notification.getCreatedBy().getId(), 2);
		Assert.assertEquals(notification.getCreatedOn(), new DateTime(2010, 8,
				5, 9, 9, 0, 0, DateTimeZone.UTC));
		Assert.assertEquals(notification.getOrganization().getId(), 1);
		Assert.assertEquals(notification.getSpace().getId(), 1);
		Assert.assertEquals(notification.getSubscriptionId(), null);
		Assert.assertEquals(notification.getType(), NotificationType.ALERT);
		Assert.assertEquals(notification.getUser().getId(), 1);
		Assert.assertEquals(notification.getViewedOn(), new DateTime(2010, 8,
				5, 12, 1, 0, 0, DateTimeZone.UTC));
	}

	@Test
	public void getInboxNew() {
		List<Notification> notifications = getAPI().getInboxNew(2, 1, null);

		Assert.assertEquals(notifications.size(), 2);
		Assert.assertEquals(notifications.get(0).getId(), 65);
		Assert.assertEquals(notifications.get(1).getId(), 62);
	}

	@Test
	public void getInboxNewCount() {
		int count = getAPI().getInboxNewCount();

		Assert.assertEquals(count, 37);
	}

	@Test
	public void getInboxViewed() {
		List<Notification> notifications = getAPI().getInboxViewed(2, 0,
				NotificationDateType.CREATED, null,
				new DateTime(2010, 5, 1, 0, 0, 0, 0, DateTimeZone.UTC),
				new DateTime(2010, 10, 1, 0, 0, 0, 0, DateTimeZone.UTC),
				Collections.singleton(2), false);

		Assert.assertEquals(notifications.size(), 2);
		Assert.assertEquals(notifications.get(0).getId(), 9);
		Assert.assertEquals(notifications.get(1).getId(), 2);
	}

	@Test
	public void getSettings() {
		NotificationSettings settings = getAPI().getSettings();

		Assert.assertEquals(settings.isDigest(), true);
		Assert.assertEquals(settings.isDirect(), true);
	}

	@Test
	public void updateSettings() {
		getAPI().updateSettings(new NotificationSettings(false, false));
	}

	@Test
	public void markAsViewed() {
		getAPI().markAsViewed(4);
	}

	@Test
	public void markAsNotViewed() {
		getAPI().markAsNotViewed(2);
	}
}
