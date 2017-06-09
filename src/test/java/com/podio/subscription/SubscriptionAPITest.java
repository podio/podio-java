package com.podio.subscription;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Assert;
import org.junit.Test;

import com.podio.APIFactoryProvider;
import com.podio.common.Reference;
import com.podio.common.ReferenceType;

public class SubscriptionAPITest {

	private SubscriptionAPI getAPI() {
		return APIFactoryProvider.getDefault().getAPI(SubscriptionAPI.class);
	}

	@Test
	public void getSubscriptionById() {
		Subscription subscription = getAPI().getSubscription(1);

		Assert.assertEquals(subscription.getStartedOn(), new DateTime(2010, 7,
				29, 16, 2, 0, 0, DateTimeZone.UTC));
		Assert.assertEquals(subscription.getNotifications(), 0);
		Assert.assertEquals(subscription.getReference().getType(),
				ReferenceType.APP);
		Assert.assertEquals(subscription.getReference().getId(), 1);
	}

	@Test
	public void getSubscriptionByReference() {
		Subscription subscription = getAPI().getSubscription(
				new Reference(ReferenceType.APP, 1));

		Assert.assertEquals(subscription.getStartedOn(), new DateTime(2010, 7,
				29, 16, 2, 0, 0, DateTimeZone.UTC));
		Assert.assertEquals(subscription.getNotifications(), 0);
		Assert.assertEquals(subscription.getReference().getType(),
				ReferenceType.APP);
		Assert.assertEquals(subscription.getReference().getId(), 1);
	}

	@Test
	public void subscribe() {
		getAPI().subscribe(new Reference(ReferenceType.APP, 2));
	}

	@Test
	public void unsubscribeById() {
		getAPI().unsubscribe(1);
	}

	@Test
	public void unsubscribeByReference() {
		getAPI().unsubscribe(new Reference(ReferenceType.APP, 1));
	}
}
