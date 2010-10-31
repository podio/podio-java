package com.podio.user;

import junit.framework.Assert;

import org.junit.Test;

import com.podio.BaseAPIFactory;

public class UserAPITest {

	private UserAPI getAPI() {
		return new UserAPI(BaseAPIFactory.get());
	}

	@Test
	public void getStatus() {
		UserStatus status = getAPI().getStatus();

		User user = status.getUser();
		Assert.assertEquals(user.getId(), 1);
		Assert.assertEquals(user.getMail(), "dev@hoisthq.com");
		Assert.assertEquals(user.getType(), UserType.ADMIN);
		Assert.assertEquals(user.getLocale().getLanguage(), "en");
		Assert.assertEquals(user.getTimezone().getID(), "Europe/Copenhagen");

		Assert.assertEquals(status.getInboxNew(), 37);
		Assert.assertEquals(status.getTaskMail(),
				"task-2-1-l6msvc@inbox.podio.com");
	}
}
