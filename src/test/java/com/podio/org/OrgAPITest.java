package com.podio.org;

import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;

import org.junit.Test;

import com.podio.BaseAPIFactory;
import com.podio.space.SpaceMini;

public class OrgAPITest {

	private OrgAPI getAPI() {
		return new OrgAPI(BaseAPIFactory.get());
	}

	@Test
	public void getOrganization() {
		Organization org = getAPI().getOrganization(1);

		Assert.assertEquals(org.getName(), "Hoist");
		Assert.assertEquals(org.getId(), 1);
	}

	@Test
	public void getOrganizations() throws URISyntaxException {
		List<Organization> organizations = getAPI().getOrganizations();
		Assert.assertEquals(organizations.size(), 2);
		Organization org = organizations.get(0);
		Assert.assertEquals(org.getId(), 1);
		Assert.assertEquals(org.getName(), "Hoist");
		List<SpaceMini> spaces = org.getSpaces();
		Assert.assertEquals(spaces.size(), 1);
		SpaceMini space = spaces.get(0);
		Assert.assertEquals(space.getId(), 1);
		Assert.assertEquals(space.getName(), "API");
	}
}
