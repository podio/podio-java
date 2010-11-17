package com.podio.calendar;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.joda.time.LocalDate;

import com.podio.BaseAPI;
import com.podio.common.ReferenceType;
import com.podio.serialize.DateTimeUtil;
import com.sun.jersey.api.client.WebResource;

public class CalendarAPI {

	private final BaseAPI baseAPI;

	public CalendarAPI(BaseAPI baseAPI) {
		this.baseAPI = baseAPI;
	}

	private Calendar getCalendar(String path, LocalDate dateFrom,
			LocalDate dateTo, List<Integer> spaceIds, ReferenceType... types) {
		WebResource resource = baseAPI
				.getApiResource("/calendar/" + path + "/");
		resource = resource.queryParam("date_from",
				DateTimeUtil.formatDate(dateFrom));
		resource = resource.queryParam("date_to",
				DateTimeUtil.formatDate(dateTo));
		if (spaceIds != null && spaceIds.size() > 0) {
			String spaceIdsStr = "";
			for (Integer spaceId : spaceIds) {
				if (spaceIdsStr.length() > 0) {
					spaceIdsStr += ",";
				}
				spaceIdsStr += spaceId;
			}

			resource = resource.queryParam("space_ids", spaceIdsStr);
		}
		if (types.length > 0) {
			String typesStr = "";
			for (ReferenceType type : types) {
				if (typesStr.length() > 0) {
					typesStr += ",";
				}
				typesStr += type;
			}

			resource = resource.queryParam("types", typesStr);
		}

		return resource.accept(MediaType.APPLICATION_JSON_TYPE).get(
				Calendar.class);
	}

	/**
	 * Returns the items and tasks that are related to the given app.
	 */
	public Calendar getApp(int appId, LocalDate dateFrom, LocalDate dateTo,
			ReferenceType... types) {
		return getCalendar("app/" + appId, dateFrom, dateTo, null, types);
	}

	/**
	 * Returns all items and tasks that the user have access to in the given
	 * space. Tasks with reference to other spaces are not returned or tasks
	 * with no reference.
	 */
	public Calendar getSpace(int spaceId, LocalDate dateFrom, LocalDate dateTo,
			ReferenceType... types) {
		return getCalendar("space/" + spaceId, dateFrom, dateTo, null, types);
	}

	/**
	 * Returns all items that the user have access to and all tasks that are
	 * assigned to the user. The items and tasks can be filtered by a list of
	 * space ids, but tasks without a reference will always be returned.
	 */
	public Calendar getGlobal(LocalDate dateFrom, LocalDate dateTo,
			List<Integer> spaceIds, ReferenceType... types) {
		return getCalendar("", dateFrom, dateTo, spaceIds, types);
	}
}
