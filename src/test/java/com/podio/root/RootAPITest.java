package com.podio.root;

import org.junit.Assert;

import org.junit.Test;

import com.podio.ResourceFactoryProvider;

public class RootAPITest {

	private RootAPI getAPI() {
		return new RootAPI(ResourceFactoryProvider.getDefault());
	}

	@Test
	public void getStatus() {
		SystemStatus status = getAPI().getStatus();
		Assert.assertEquals(status.getVersion(), "1.0.1");
		Assert.assertEquals(status.isDatabase(), true);
		Assert.assertEquals(status.isMessaging(), true);
	}
}
