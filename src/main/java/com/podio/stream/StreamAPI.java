package com.podio.stream;

import java.util.List;

import org.joda.time.DateTime;

import com.podio.ResourceFactory;
import com.podio.common.Reference;
import com.podio.serialize.DateTimeUtil;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

/**
 * Subscriptions allows the user to be notified when an object is created,
 * updated, delete, comments added to it or rated.
 */
public class StreamAPI {

	private final ResourceFactory resourceFactory;

	public StreamAPI(ResourceFactory baseAPI) {
		this.resourceFactory = baseAPI;
	}

	/**
	 * Returns an object (item or status) as a stream object. This is useful
	 * when a new status has been posted and should be rendered directly in the
	 * stream without reloading the entire stream.
	 * 
	 * @param reference
	 *            The reference to the item
	 * @return The stream object
	 */
	public StreamObject getStreamObject(Reference reference) {
		return resourceFactory.getApiResource(
				"/stream/" + reference.toURLFragment(false)).get(
				StreamObject.class);
	}

	/**
	 * Returns the global stream. This includes items and statuses with
	 * comments, ratings, files and edits.
	 * 
	 * @param limit
	 *            How many objects should be returned, defaults to 10
	 * @param offset
	 *            How far should the objects be offset, defaults to 0
	 * @param latest
	 *            The date and time that all events should be before, defaults
	 *            to no limit
	 * @return The list of stream objects
	 */
	public List<StreamObject> getGlobalStream(Integer limit, Integer offset,
			DateTime latest) {
		return getStream("/stream/", limit, offset, latest);
	}

	/**
	 * Returns the stream for the organization. Is identical to the global
	 * stream, but only returns objects in the organization.
	 * 
	 * @param limit
	 *            How many objects should be returned, defaults to 10
	 * @param offset
	 *            How far should the objects be offset, defaults to 0
	 * @param latest
	 *            The date and time that all events should be before, defaults
	 *            to no limit
	 * @return The list of stream objects
	 */
	public List<StreamObject> getOrganizationStream(int orgId, Integer limit,
			Integer offset, DateTime latest) {
		return getStream("/stream/org/" + orgId + "/", limit, offset, latest);
	}

	/**
	 * Returns the stream for the space. Is identical to the global stream, but
	 * only returns objects in the space.
	 * 
	 * @param limit
	 *            How many objects should be returned, defaults to 10
	 * @param offset
	 *            How far should the objects be offset, defaults to 0
	 * @param latest
	 *            The date and time that all events should be before, defaults
	 *            to no limit
	 * @return The list of stream objects
	 */
	public List<StreamObject> getSpaceStream(int spaceId, Integer limit,
			Integer offset, DateTime latest) {
		return getStream("/stream/space/" + spaceId + "/", limit, offset,
				latest);
	}

	private List<StreamObject> getStream(String path, Integer limit,
			Integer offset, DateTime latest) {
		WebResource resource = resourceFactory.getApiResource(path);
		if (limit != null) {
			resource = resource.queryParam("limit", limit.toString());
		}
		if (offset != null) {
			resource = resource.queryParam("offset", offset.toString());
		}
		if (latest != null) {
			resource = resource.queryParam("latest",
					DateTimeUtil.formatDateTime(latest));
		}
		return resource.get(new GenericType<List<StreamObject>>() {
		});
	}
}
