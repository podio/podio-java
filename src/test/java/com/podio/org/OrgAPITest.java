package com.podio.org;

import java.net.URISyntaxException;

import junit.framework.Assert;

import org.junit.Test;

import com.podio.BaseAPIFactory;

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
		// List<Organization> organizations = getAPI().getOrganizations();
		// Assert.assertEquals(organizations.size(), 2);
		// Organization org = organizations.get(0);
		// Assert.assertEquals(org.getId(), 1);
		// Assert.assertEquals(org.getName(), "Hoist");
		// List<Space> spaces = org.getSpaces();
		// Assert.assertEquals(spaces.size(), 1);
		// Space space = spaces.get(0);
		// Assert.assertEquals(space.getId(), 1);
		// Assert.assertEquals(space.getName(), "API");
	}
}
