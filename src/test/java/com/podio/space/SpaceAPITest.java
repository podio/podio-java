package com.podio.space;

import junit.framework.Assert;

import org.junit.Test;

import com.podio.BaseAPIFactory;

public class SpaceAPITest {

	private SpaceAPI getAPI() {
		return new SpaceAPI(BaseAPIFactory.get());
	}

	@Test
	public void getSpaceByURL() {
		SpaceWithOrganization space = getAPI().getByURL("https://hoist.podio.com/api/");

		Assert.assertEquals(space.getId(), 1);
		Assert.assertEquals(space.getOrganization().getId(), 1);
	}
}
