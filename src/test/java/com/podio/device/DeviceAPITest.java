package com.podio.device;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.podio.APIFactoryProvider;

public class DeviceAPITest {

	private DeviceAPI getAPI() {
		return APIFactoryProvider.getDefault().getAPI(DeviceAPI.class);
	}

	@Test
	public void getNonExistingApp() {
		List<PushSubscription> subscriptions = this.getAPI()
				.getPushSubscriptions();
		Assert.assertEquals(subscriptions.size(), 7);

		PushSubscription subscription = subscriptions.get(0);
		Assert.assertEquals(subscription.getChannel(), "/space/1");
		Assert.assertEquals(subscription.getSignature().length(), 40);
		Assert.assertTrue(subscription.getTimestamp() > 1);

	}
}
