package com.podio.space;

import java.util.Collections;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Assert;
import org.junit.Test;

import com.podio.BaseAPIFactory;
import com.podio.common.Role;

public class SpaceAPITest {

	private SpaceAPI getAPI() {
		return new SpaceAPI(BaseAPIFactory.get());
	}

	@Test
	public void createSpace() {
		SpaceCreateResponse response = getAPI().createSpace(
				new SpaceCreate("New", true, true, 1));

		Assert.assertTrue(response.getId() > 1);
		Assert.assertEquals(response.getUrl(), "https://hoist.podio.com/new/");
	}

	@Test
	public void getSpace() {
		Space space = getAPI().getSpace(1);

		Assert.assertEquals(space.getId(), 1);
		Assert.assertEquals(space.getName(), "API");
		Assert.assertEquals(space.getUrl(), "https://hoist.podio.com/api/");
		Assert.assertEquals(space.getStatus(), SpaceStatus.ACTIVE);
		Assert.assertEquals(space.getCreatedOn(), new DateTime(2010, 8, 9, 14,
				49, 0, 0, DateTimeZone.UTC));
		Assert.assertEquals(space.getCreatedBy().getId(), 1);
		Assert.assertEquals(space.getRole(), Role.CREATOR);
	}

	@Test
	public void updateSpace() {
		getAPI().updateSpace(1, new SpaceUpdate("Our API", false, false));
	}

	@Test
	public void getSpaceByURL() {
		SpaceWithOrganization space = getAPI().getSpaceByURL(
				"https://hoist.podio.com/api/");

		Assert.assertEquals(space.getId(), 1);
		Assert.assertEquals(space.getOrganization().getId(), 1);
	}

	@Test
	public void inviteToSpace() {
		getAPI().inviteToSpace(
				1,
				new SpaceInvitation(Role.REGULAR, "Subject", "Message", true,
						true, Collections.singletonList(5), Collections
								.singletonList("cho@cubitech.dk")));
	}

	@Test
	public void getSpaceStatistics() {
		SpaceStatistics statistics = getAPI().getSpaceStatistics(1);

		Assert.assertEquals(statistics.getCreatedOn(), new DateTime(2010, 8, 9,
				14, 49, 0, 0, DateTimeZone.UTC));
		Assert.assertEquals(statistics.getComments(), 5);
		Assert.assertEquals(statistics.getApps(), 1);
		Assert.assertEquals(statistics.getItems(), 2);
		Assert.assertEquals(statistics.getMembers(), 3);
		Assert.assertEquals(statistics.getStatuses(), 2);
	}

	@Test
	public void getSpaceMembership() {
		SpaceMember member = getAPI().getSpaceMembership(1, 1);

		Assert.assertEquals(member.getEndedOn(), null);
		Assert.assertEquals(member.getInvitedOn(), new DateTime(2010, 8, 8, 15,
				7, 0, 0, DateTimeZone.UTC));
		Assert.assertEquals(member.getStartedOn(), new DateTime(2010, 8, 9, 15,
				7, 0, 0, DateTimeZone.UTC));
		Assert.assertEquals(member.getUser().getId(), 1);
		Assert.assertEquals(member.getRole(), Role.ADMIN);
	}
}
