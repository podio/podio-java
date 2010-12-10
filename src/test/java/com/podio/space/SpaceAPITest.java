package com.podio.space;

import java.util.Collections;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Assert;
import org.junit.Test;

import com.podio.BaseAPIFactory;
import com.podio.common.Role;
import com.podio.user.UserMini;

public class SpaceAPITest {

	private SpaceAPI getAPI() {
		return new SpaceAPI(BaseAPIFactory.get());
	}

	private SpaceAPI getAPI(int userId) {
		return new SpaceAPI(BaseAPIFactory.get(userId));
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
	public void deleteSpace() {
		getAPI().deleteSpace(1);
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
	public void resendInvitation() {
		getAPI(2).resendInvitation(2, 1,
				new SpaceInvitationUpdate("Subject", "Message"));
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

	@Test
	public void updateSpaceMembership() {
		getAPI().updateSpaceMembership(1, 1, Role.REGULAR);
	}

	@Test
	public void endSpaceMembership() {
		getAPI().endSpaceMembership(1, 1);
	}

	@Test
	public void getActiveMembers() {
		List<SpaceMember> members = getAPI().getActiveMembers(1);

		Assert.assertEquals(members.size(), 3);
		Assert.assertEquals(members.get(0).getUser().getId(), 1);
		Assert.assertEquals(members.get(0).getRole(), Role.ADMIN);
		Assert.assertEquals(members.get(0).getInvitedOn(), new DateTime(2010,
				8, 8, 15, 7, 0, 0, DateTimeZone.UTC));
		Assert.assertEquals(members.get(0).getStartedOn(), new DateTime(2010,
				8, 9, 15, 7, 0, 0, DateTimeZone.UTC));
		Assert.assertEquals(members.get(0).getEndedOn(), null);
		Assert.assertEquals(members.get(1).getUser().getId(), 2);
		Assert.assertEquals(members.get(2).getUser().getId(), 3);
	}

	@Test
	public void getInvitedMembers() {
		List<SpaceMember> members = getAPI(2).getInvitedMembers(2);

		Assert.assertEquals(members.size(), 1);
		Assert.assertEquals(members.get(0).getUser().getId(), 1);
		Assert.assertEquals(members.get(0).getStartedOn(), null);
	}

	@Test
	public void getEndedMembers() {
		List<SpaceMember> members = getAPI(2).getEndedMembers(3);

		Assert.assertEquals(members.size(), 2);
		Assert.assertEquals(members.get(0).getUser().getId(), 1);
		Assert.assertEquals(members.get(0).getEndedOn(), new DateTime(2010, 8,
				9, 15, 12, 0, 0, DateTimeZone.UTC));
		Assert.assertEquals(members.get(1).getUser().getId(), 4);
	}

	@Test
	public void getTopUsers() {
		List<UserMini> topUsers = getAPI().getTopUsers(1, null);

		Assert.assertEquals(topUsers.size(), 3);
		Assert.assertEquals(topUsers.get(0).getId(), 1);
		Assert.assertEquals(topUsers.get(1).getId(), 2);
		Assert.assertEquals(topUsers.get(2).getId(), 3);
	}

	@Test
	public void getTopSpaces() {
		List<SpaceWithOrganization> topSpaces = getAPI().getTopSpaces(null);

		Assert.assertEquals(topSpaces.size(), 1);
		Assert.assertEquals(topSpaces.get(0).getId(), 1);
	}
}
