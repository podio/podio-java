package com.podio.status;

import java.util.Collections;

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
				new StatusCreate(1, "Hello from Java", Collections
						.<Integer> emptyList(), Collections
						.<Integer> emptyList()));

		Assert.assertTrue(response.getId() > 1);
	}
}
