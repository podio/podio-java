package com.podio.root;

import org.junit.Assert;
import org.junit.Test;

import com.podio.APIFactoryProvider;

public class RootAPITest {

	private RootAPI getAPI() {
		return APIFactoryProvider.getDefault().getRootAPI();
	}

	@Test
	public void getStatus() {
		SystemStatus status = getAPI().getStatus();
		Assert.assertEquals(status.getVersion(), "1.9");
		Assert.assertEquals(status.isDatabase(), true);
		// Assert.assertEquals(status.isMessaging(), true);
	}
}
