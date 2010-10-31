package com.podio.status;

import junit.framework.Assert;

import org.junit.Test;

import com.podio.BaseAPIFactory;

public class StatusAPITest {

	private StatusAPI getAPI() {
		return new StatusAPI(BaseAPIFactory.get());
	}

	@Test
	public void createStatus() {
		StatusCreateResponse response = getAPI().createStatus(
				new StatusCreate(2928, "Hello from Java", null, null));

		Assert.assertTrue(response.getId() > 1);
	}
}
