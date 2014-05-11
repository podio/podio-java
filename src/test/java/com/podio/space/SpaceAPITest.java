package com.podio.space;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Assert;
import org.junit.Test;

import com.podio.APIApplicationException;
import com.podio.APIFactoryProvider;
import com.podio.ResourceFactoryProvider;
import com.podio.common.Role;

public class SpaceAPITest {

	private SpaceAPI getAPI() {
		return APIFactoryProvider.getDefault().getAPI(SpaceAPI.class);
	}

	private SpaceAPI getAPI(int userId) {
		return new SpaceAPI(ResourceFactoryProvider.getUser(userId));
	}

	@Test
	public void createSpace() {
		SpaceCreateResponse response = getAPI().createSpace(
				new SpaceCreate("New", true, true, 1));

		Assert.assertTrue(response.getId() > 1);
		Assert.assertEquals(response.getUrl(), "https://podio.com/hoist/new");
	}

	@Test
	public void getSpace() {
		Space space = getAPI().getSpace(1);

		Assert.assertEquals(space.getId(), 1);
		Assert.assertEquals(space.getName(), "API");
		Assert.assertEquals(space.getUrl(), "https://podio.com/hoist/api");
		Assert.assertEquals(space.getCreatedOn(), new DateTime(2010, 8, 9, 14,
				49, 0, 0, DateTimeZone.UTC));
		Assert.assertEquals(space.getCreatedBy().getUserId().intValue(), 1);
		Assert.assertEquals(space.getRole(), Role.ADMIN);
	}

	@Test
	public void updateSpace() {
		getAPI().updateSpace(1, new SpaceUpdate("Our API", false, false));
	}

	@Test
	public void getSpaceByURL() {
		SpaceWithOrganization space = getAPI().getSpaceByURL(
				"https://podio.com/hoist/api/");

		Assert.assertEquals(space.getId(), 1);
		Assert.assertEquals(space.getOrganization().getId(), 1);
	}

	@Test
	public void getSpaceMembership() {
		SpaceMember member = getAPI().getSpaceMembership(1, 1);

		Assert.assertEquals(member.getEndedOn(), null);
		Assert.assertEquals(member.getInvitedOn(), new DateTime(2010, 8, 9, 15,
				7, 0, 0, DateTimeZone.UTC));
		Assert.assertEquals(member.getStartedOn(), new DateTime(2010, 8, 9, 15,
				7, 0, 0, DateTimeZone.UTC));
		Assert.assertEquals(member.getUser().getUserId().intValue(), 1);
		Assert.assertEquals(member.getRole(), Role.ADMIN);
	}

	@Test
	public void updateSpaceMembership() {
		try {
			getAPI().updateSpaceMembership(1, 1, Role.REGULAR);
			Assert.fail();
		} catch (APIApplicationException e) {
			// Expected
		}

	}

	@Test
	public void endSpaceMembership() {
		getAPI().endSpaceMembership(1, 2);
	}

	@Test
	public void getActiveMembers() {
		List<SpaceMember> members = getAPI().getActiveMembers(1);

		Assert.assertEquals(members.size(), 3);
		Assert.assertEquals(members.get(0).getUser().getUserId().intValue(), 4);
		Assert.assertEquals(members.get(1).getUser().getUserId().intValue(), 2);
		Assert.assertEquals(members.get(2).getUser().getUserId().intValue(), 1);
		Assert.assertEquals(members.get(2).getRole(), Role.ADMIN);
		Assert.assertEquals(members.get(2).getInvitedOn(), new DateTime(2010,
				8, 9, 15, 7, 0, 0, DateTimeZone.UTC));
		Assert.assertEquals(members.get(2).getStartedOn(), new DateTime(2010,
				8, 9, 15, 7, 0, 0, DateTimeZone.UTC));
		Assert.assertEquals(members.get(2).getEndedOn(), null);
	}

	@Test
	public void getEndedMembers() {
		List<SpaceMember> members = getAPI(2).getEndedMembers(3);

		Assert.assertEquals(members.size(), 3);
		Assert.assertEquals(members.get(0).getUser().getUserId().intValue(), 4);
		Assert.assertEquals(members.get(0).getEndedOn(), new DateTime(2010, 9,
				30, 12, 35, 0, 0, DateTimeZone.UTC));
		Assert.assertEquals(members.get(1).getUser().getUserId().intValue(), 1);
	}

	@Test
	public void getTopSpaces() {
		List<SpaceWithOrganization> topSpaces = getAPI().getTopSpaces(null);

		Assert.assertEquals(topSpaces.size(), 6);
		Assert.assertEquals(topSpaces.get(0).getId(), 1);
	}
}
