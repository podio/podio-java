package com.podio.contact;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.podio.BaseAPI;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

public class ContactAPI {

	private final BaseAPI baseAPI;

	public ContactAPI(BaseAPI baseAPI) {
		this.baseAPI = baseAPI;
	}

	public Profile getContact(int userId) {
		return baseAPI.getResource("/contact/" + userId)
				.accept(MediaType.APPLICATION_JSON_TYPE).get(Profile.class);
	}

	public List<Profile> getSpaceContacts(int spaceId, String key,
			String value, Integer limit, Integer offset, String type,
			String order) {
		WebResource resource = baseAPI.getResource("/contact/space/" + spaceId);
		if (key != null && value != null) {
			resource = resource.queryParam("key", key).queryParam("value",
					value);
		}
		if (limit != null) {
			resource = resource.queryParam("limit", limit.toString());
		}
		if (offset != null) {
			resource = resource.queryParam("offset", offset.toString());
		}
		if (type != null) {
			resource = resource.queryParam("type", type);
		}
		if (order != null) {
			resource = resource.queryParam("order", order);
		}

		return resource.accept(MediaType.APPLICATION_JSON_TYPE).get(
				new GenericType<List<Profile>>() {
				});
	}
}
