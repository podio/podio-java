package com.podio.calendar;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import com.podio.APIFactoryProvider;
import com.podio.common.ReferenceType;

public class CalendarAPITest {

	private CalendarAPI getAPI() {
		return APIFactoryProvider.getDefault().getAPI(CalendarAPI.class);
	}

	@Test
	public void getAppCalendar() {
		List<Event> events = getAPI().getApp(1, new LocalDate(2010, 8, 1),
				new LocalDate(2010, 8, 31));

		Assert.assertEquals(events.size(), 3);
		Event event = events.get(0);
		Assert.assertEquals(event.getType(), ReferenceType.ITEM);
		Assert.assertEquals(event.getId(), 1);
		Assert.assertEquals(event.getGroup(), "Bug");
		Assert.assertEquals(event.getTitle(), "æøå");
		Assert.assertEquals(event.getStart(), new DateTime(2010, 8, 4, 9, 0, 0,
				0, DateTimeZone.UTC));
		Assert.assertEquals(event.getEnd(), new DateTime(2010, 8, 4, 10, 0, 0,
				0, DateTimeZone.UTC));
		Assert.assertEquals(event.getLink(),
				"https://hoist.podio.com/api/item/1");
		Assert.assertEquals(event.getSpace().getId(), 1);
		Assert.assertEquals(event.getOrganization().getId(), 1);
	}

	@Test
	public void getSpaceCalendar() {
		List<Event> events = getAPI().getSpace(1, new LocalDate(2010, 8, 1),
				new LocalDate(2010, 8, 31));
		Assert.assertEquals(events.size(), 3);
	}

	@Test
	public void getGlobalCalendar() {
		List<Event> events = getAPI().getGlobal(new LocalDate(2010, 8, 1),
				new LocalDate(2010, 8, 31), null);
		Assert.assertEquals(events.size(), 3);
	}
}
