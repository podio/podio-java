package com.podio.contact;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import com.podio.APIFactoryProvider;

public class ContactAPITest {

	private ContactAPI getAPI() {
		return APIFactoryProvider.getDefault().getAPI(ContactAPI.class);
	}

	@Test
	public void getContact() {
		Profile contact = getAPI().getContact(1);

		Assert.assertEquals(contact.getUserId().intValue(), 1);
		Assert.assertEquals(contact.getName(), "Christian Holm");
		Assert.assertEquals(contact.getAvatar(), new Integer(9));
		Assert.assertEquals(contact.getBirthdate(), new LocalDate(1978, 12, 11));
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
		Assert.assertEquals(contact.getLastSeenOn(), new DateTime(2011, 7, 23, 13,
				0, 0, 0, DateTimeZone.UTC));
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
	public void getContactTotals() {
		ContactTotal total = getAPI().getContactTotal();

		Assert.assertEquals(total.getUser().getCount(), 5);
	}

	@Test
	public void getSpaceContactsByMail() {
		List<Profile> contacts = getAPI().getSpaceContacts(1,
				ProfileField.MAIL, "haugstrup@hoisthq.com", null, null,
				ProfileType.FULL, null);

		Assert.assertEquals(contacts.size(), 1);
		Assert.assertEquals(contacts.get(0).getUserId().intValue(), 2);
	}
}
