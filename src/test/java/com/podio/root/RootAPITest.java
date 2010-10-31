package com.podio.root;

import junit.framework.Assert;

import org.junit.Test;

import com.podio.BaseAPIFactory;

public class RootAPITest {

	private RootAPI getAPI() {
		return new RootAPI(BaseAPIFactory.get());
	}

	@Test
	public void getStatus() {
		SystemStatus status = getAPI().getStatus();
		Assert.assertEquals(status.getVersion(), "1.0.1");
		Assert.assertEquals(status.isDatabase(), true);
		Assert.assertEquals(status.isMessaging(), true);
	}
}
