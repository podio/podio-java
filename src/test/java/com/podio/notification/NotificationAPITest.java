package com.podio.notification;

import org.junit.Assert;
import org.junit.Test;

import com.podio.APIFactoryProvider;

public class NotificationAPITest {

	private NotificationAPI getAPI() {
		return APIFactoryProvider.getDefault().getAPI(NotificationAPI.class);
	}

	@Test
	public void getInboxNewCount() {
		int count = getAPI().getInboxNewCount();

		Assert.assertEquals(count, 59);
	}

	@Test
	public void markAsViewed() {
		getAPI().markAsViewed(4);
	}
}
