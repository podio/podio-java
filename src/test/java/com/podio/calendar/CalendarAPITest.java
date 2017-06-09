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
		Assert.assertEquals(event.getRefType(), ReferenceType.ITEM);
		Assert.assertEquals(event.getRefId(), 1);
		Assert.assertEquals(event.getUID(), "item_1_2");
		Assert.assertEquals(event.getTitle(), "no & yes");
		Assert.assertEquals(event.getDescription(), "æøå");
		Assert.assertEquals(event.getLocation(), null);
		Assert.assertEquals(event.getVersion(), 0);
		Assert.assertEquals(event.isBusy(), false);
		Assert.assertEquals(event.getStatus(), null);
		Assert.assertEquals(event.getStart(), new DateTime(2010, 8, 4, 9, 0, 0,
				0, DateTimeZone.UTC));
		Assert.assertEquals(event.getEnd(), new DateTime(2010, 8, 4, 10, 0, 0,
				0, DateTimeZone.UTC));
		Assert.assertEquals(event.getLink(),
				"https://podio.com/hoist/api/apps/bugs/items/1");
		Assert.assertEquals(event.getApplication().getId(), 1);
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
		Assert.assertEquals(events.size(), 4);
	}
}
