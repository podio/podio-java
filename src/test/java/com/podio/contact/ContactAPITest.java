package com.podio.contact;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.podio.BaseAPIFactory;

public class ContactAPITest {

	private ContactAPI getAPI() {
		return new ContactAPI(BaseAPIFactory.get());
	}

	@Test
	public void getContact() {
		Profile contact = getAPI().getContact(1);

		Assert.assertEquals(contact.getUserId(), 1);
		Assert.assertEquals(contact.getName(), "Christian Holm");
		Assert.assertEquals(contact.getAvatar(), new Integer(9));
		Assert.assertEquals(contact.getBirthdate(), new Date(78, 11, 11));
		Assert.assertEquals(contact.getOrganization(), "Podio");
		Assert.assertEquals(contact.getSkype(), "cho@cubitech.dk");
		Assert.assertEquals(contact.getAbout(), "King of the API, baby!");
		Assert.assertEquals(contact.getAddresses().get(0),
				"Borgergade 144, 1.tv.");
		Assert.assertEquals(contact.getAddresses().get(1), "1300 København K");
		Assert.assertEquals(contact.getIms(), null);
		Assert.assertEquals(contact.getLocations().get(0), "København");
		Assert.assertEquals(contact.getMails().get(0), "dev@hoisthq.com");
		Assert.assertEquals(contact.getMails().get(1), "holm@hoisthq.com");
		Assert.assertEquals(contact.getPhones().get(0), "26217563");
		Assert.assertEquals(contact.getTitles().get(0), "Develoment Team Lead");
		Assert.assertEquals(contact.getUrls().get(0),
				"http://www.facebook.com/profile.php?id=504601663");
	}

	@Test
	public void getSpaceContactsByMail() {
		List<Profile> contacts = getAPI().getSpaceContacts(1, "mail",
				"haugstrup@hoisthq.com", null, null, null, null);

		Assert.assertEquals(contacts.size(), 1);
		Assert.assertEquals(contacts.get(0).getUserId(), 2);
	}
}
