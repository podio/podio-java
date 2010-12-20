package com.podio.contact;

import java.util.List;

import org.junit.Assert;

import org.joda.time.LocalDate;
import org.junit.Test;

import com.podio.ResourceFactoryProvider;

public class ContactAPITest {

	private ContactAPI getAPI() {
		return new ContactAPI(ResourceFactoryProvider.get());
	}

	@Test
	public void getContact() {
		Profile contact = getAPI().getContact(1);

		Assert.assertEquals(contact.getId(), 1);
		Assert.assertEquals(contact.getName(), "Christian Holm");
		Assert.assertEquals(contact.getAvatar(), new Integer(9));
		Assert.assertEquals(contact.getBirthdate(), new LocalDate(1978, 12, 11));
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
	public void getContactFieldName() {
		List<String> names = getAPI().getContactField(1, ProfileField.NAME);
		Assert.assertEquals(names.size(), 1);
		Assert.assertEquals(names.get(0), "Christian Holm");
	}

	@Test
	public void getContactFieldMail() {
		List<String> mails = getAPI().getContactField(1, ProfileField.MAIL);
		Assert.assertEquals(mails.size(), 3);
		Assert.assertEquals(mails.get(0), "dev@hoisthq.com");
	}

	@Test
	public void getContactFieldAvatar() {
		List<Integer> avatars = getAPI()
				.getContactField(1, ProfileField.AVATAR);
		Assert.assertEquals(avatars.size(), 1);
		Assert.assertEquals(avatars.get(0).intValue(), 9);
	}

	@Test
	public void getContactFieldBirthdate() {
		List<LocalDate> birthdates = getAPI().getContactField(1,
				ProfileField.BIRTHDATE);
		Assert.assertEquals(birthdates.size(), 1);
		Assert.assertEquals(birthdates.get(0), new LocalDate(1978, 12, 11));
	}

	@Test
	public void getTopContacts() {
		List<Profile> contacts = getAPI().getTopContacts(2, ProfileType.FULL);

		Assert.assertEquals(contacts.size(), 2);
		Assert.assertEquals(contacts.get(0).getId(), 2);
		Assert.assertEquals(contacts.get(1).getId(), 3);
	}

	@Test
	public void getContactTotals() {
		List<ContactTotal> totals = getAPI().getContactTotals();

		Assert.assertEquals(totals.size(), 2);
		Assert.assertEquals(totals.get(0).getOrganization().getId(), 1);
		Assert.assertEquals(totals.get(0).getContacts(), 2);
		Assert.assertEquals(totals.get(1).getOrganization().getId(), 4);
		Assert.assertEquals(totals.get(1).getContacts(), 0);
	}

	@Test
	public void getSpaceContactsByMail() {
		List<Profile> contacts = getAPI().getSpaceContacts(1,
				ProfileField.MAIL, "haugstrup@hoisthq.com", null, null,
				ProfileType.FULL, null);

		Assert.assertEquals(contacts.size(), 1);
		Assert.assertEquals(contacts.get(0).getId(), 2);
	}
}
