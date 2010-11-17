package com.podio.calendar;

import java.util.List;

import junit.framework.Assert;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.Test;

import com.podio.BaseAPIFactory;
import com.podio.common.ReferenceType;

public class CalendarAPITest {

	private CalendarAPI getAPI() {
		return new CalendarAPI(BaseAPIFactory.get());
	}

	@Test
	public void getAppCalendar() {
		Calendar calendar = getAPI().getApp(1, new LocalDate(2010, 8, 1),
				new LocalDate(2010, 8, 31));

		Assert.assertEquals(calendar.getFeedToken().length(), 128);

		List<Event> events = calendar.getEvents();
		Assert.assertEquals(events.size(), 3);
		Event event = events.get(0);
		Assert.assertEquals(event.getType(), ReferenceType.ITEM);
		Assert.assertEquals(event.getId(), 1);
		Assert.assertEquals(event.getGroup(), "Bug");
		Assert.assertEquals(event.getTitle(), "זרו");
		Assert.assertEquals(event.getStart(), new DateTime(2010, 8, 4, 9, 0, 0,
				0));
		Assert.assertEquals(event.getEnd(), new DateTime(2010, 8, 4, 10, 0, 0,
				0));
		Assert.assertEquals(event.getLink(),
				"https://hoist.podio.com/api/item/1");
		Assert.assertEquals(event.getSpace().getId(), 1);
		Assert.assertEquals(event.getOrganization().getId(), 1);
	}

	@Test
	public void getSpaceCalendar() {
		Calendar calendar = getAPI().getSpace(1, new LocalDate(2010, 8, 1),
				new LocalDate(2010, 8, 31));

		Assert.assertEquals(calendar.getFeedToken().length(), 128);

		List<Event> events = calendar.getEvents();
		Assert.assertEquals(events.size(), 3);
	}

	@Test
	public void getGlobalCalendar() {
		Calendar calendar = getAPI().getGlobal(new LocalDate(2010, 8, 1),
				new LocalDate(2010, 8, 31), null);

		Assert.assertEquals(calendar.getFeedToken().length(), 128);

		List<Event> events = calendar.getEvents();
		Assert.assertEquals(events.size(), 3);
	}
}
