package com.podio.calendar;

import java.util.List;

import org.joda.time.LocalDate;

import com.podio.BaseAPI;
import com.podio.ResourceFactory;
import com.podio.common.CSVUtil;
import com.podio.common.ReferenceType;
import com.podio.serialize.DateTimeUtil;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

/**
 * The calendar is used to get the calendar for a user. The calendar includes
 * items with a date field in the interval and tasks with a due date in the
 * interval.
 * 
 * Calendar entries are always sorted by date.
 */
public class CalendarAPI extends BaseAPI {

	public CalendarAPI(ResourceFactory resourceFactory) {
		super(resourceFactory);
	}

	private List<Event> getCalendar(String path, LocalDate dateFrom,
			LocalDate dateTo, List<Integer> spaceIds, ReferenceType... types) {
		WebResource resource = getResourceFactory().getApiResource(
				"/calendar/" + path + "/");
		resource = resource.queryParam("date_from",
				DateTimeUtil.formatDate(dateFrom));
		resource = resource.queryParam("date_to",
				DateTimeUtil.formatDate(dateTo));
		if (spaceIds != null && spaceIds.size() > 0) {
			resource = resource
					.queryParam("space_ids", CSVUtil.toCSV(spaceIds));
		}
		if (types.length > 0) {
			resource = resource.queryParam("types",
					CSVUtil.toCSV((Object[]) types));
		}

		return resource.get(new GenericType<List<Event>>() {
		});
	}

	/**
	 * Returns the items and tasks that are related to the given app.
	 * 
	 * @param appId
	 *            The id of the app
	 * @param dateFrom
	 *            The from date
	 * @param dateTo
	 *            The to date
	 * @param types
	 *            The types of events that should be returned. Leave out to get
	 *            all types of events.
	 * @return The events in the calendar
	 */
	public List<Event> getApp(int appId, LocalDate dateFrom, LocalDate dateTo,
			ReferenceType... types) {
		return getCalendar("app/" + appId, dateFrom, dateTo, null, types);
	}

	/**
	 * Returns all items and tasks that the user have access to in the given
	 * space. Tasks with reference to other spaces are not returned or tasks
	 * with no reference.
	 * 
	 * @param spaceId
	 *            The id of the space
	 * @param dateFrom
	 *            The from date
	 * @param dateTo
	 *            The to date
	 * @param types
	 *            The types of events that should be returned. Leave out to get
	 *            all types of events.
	 * @return The events in the calendar
	 */
	public List<Event> getSpace(int spaceId, LocalDate dateFrom,
			LocalDate dateTo, ReferenceType... types) {
		return getCalendar("space/" + spaceId, dateFrom, dateTo, null, types);
	}

	/**
	 * Returns all items that the user have access to and all tasks that are
	 * assigned to the user. The items and tasks can be filtered by a list of
	 * space ids, but tasks without a reference will always be returned.
	 * 
	 * @param dateFrom
	 *            The from date
	 * @param dateTo
	 *            The to date
	 * @param types
	 *            The types of events that should be returned. Leave out to get
	 *            all types of events.
	 * @return The events in the calendar
	 */
	public List<Event> getGlobal(LocalDate dateFrom, LocalDate dateTo,
			List<Integer> spaceIds, ReferenceType... types) {
		return getCalendar("", dateFrom, dateTo, spaceIds, types);
	}
}
