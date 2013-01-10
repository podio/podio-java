package com.podio.status;

import java.util.Collections;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Assert;
import org.junit.Test;

import com.podio.APIFactoryProvider;
import com.podio.rating.RatingType;

public class StatusAPITest {

	private StatusAPI getAPI() {
		return APIFactoryProvider.getDefault().getAPI(StatusAPI.class);
	}

	@Test
	public void createStatus() {
		int statusId = getAPI().createStatus(
				1,
				new StatusCreate("Hello from Java", Collections
						.<Integer> emptyList(), Collections
						.<Integer> emptyList()));

		Assert.assertTrue(statusId > 1);
	}

	@Test
	public void deleteStatus() {
		getAPI().deleteStatus(1);
	}

	@Test
	public void getStatus() {
		StatusFull status = getAPI().getStatus(1);

		Assert.assertEquals(status.getStatusId(), 1);
		Assert.assertEquals(status.getCreatedBy().getId(), 1);
		Assert.assertEquals(
				status.getValue(),
				"This is going to be legen- wait for it -dary. @Andreas Haugstrup Now it's up to you to make it ha...");
		Assert.assertEquals(status.getCreatedOn(), new DateTime(2010, 8, 12,
				17, 9, 0, 0, DateTimeZone.UTC));
		Assert.assertEquals(status.getComments().size(), 2);
		Assert.assertEquals(
				status.getRatings().get(RatingType.LIKE).getCounts(1)
						.getUsers().get(0).getUserId().intValue(), 4);
		Assert.assertEquals(status.getFiles().size(), 4);
		Assert.assertEquals(status.getFiles().get(0).getId(), 34);
		Assert.assertEquals(status.isSubscribed(), true);
		Assert.assertEquals(status.getUserRatings().size(), 0);
	}

	@Test
	public void updateStatus() {
		getAPI().updateStatus(1,
				new StatusUpdate("Test", Collections.<Integer> emptyList()));
	}
}
