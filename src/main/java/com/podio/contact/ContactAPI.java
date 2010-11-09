package com.podio.contact;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
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

	/**
	 * Returns all the contact details about the user with the given id.
	 */
	public Profile getContact(int userId) {
		return baseAPI.getResource("/contact/" + userId)
				.accept(MediaType.APPLICATION_JSON_TYPE).get(Profile.class);
	}

	/**
	 * Returns the value of a contact with the specific field
	 */
	public <T, R> List<T> getContactField(int userId, ProfileField<T, R> field) {
		List<R> values = baseAPI
				.getResource("/contact/" + userId + "/" + field.getName())
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(new GenericType<List<R>>() {
				});

		List<T> formatted = new ArrayList<T>();
		for (R value : values) {
			formatted.add(field.parse(value));
		}

		return formatted;
	}

	/**
	 * Returns the top contacts for the user ordered by their overall
	 * interactive with the active user.
	 */
	public <T> List<T> getTopContacts(Integer limit, ProfileType<T> type) {
		WebResource resource = baseAPI.getResource("/contact/top/");

		if (limit != null) {
			resource = resource.queryParam("limit", limit.toString());
		}
		resource = resource.queryParam("type", type.getName());

		return resource.accept(MediaType.APPLICATION_JSON_TYPE).get(
				getGenericType(type));
	}

	/**
	 * Returns the total number of contacts by organization.
	 */
	public List<ContactTotal> getContactTotals() {
		return baseAPI.getResource("/contact/totals/")
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(new GenericType<List<ContactTotal>>() {
				});
	}

	/**
	 * Used to get a list of contacts for the user.
	 */
	public <T, F, R> List<T> getContacts(ProfileField<F, R> key, F value,
			Integer limit, Integer offset, ProfileType<T> type,
			ContactOrder order) {
		WebResource resource = baseAPI.getResource("/contact/");

		return getContactsCommon(resource, key, value, limit, offset, type,
				order);
	}

	/**
	 * Returns all the profiles of the users contacts on the given organization
	 */
	public <T, F, R> List<T> getOrganizationContacts(int organizationId,
			ProfileField<F, R> key, F value, Integer limit, Integer offset,
			ProfileType<T> type, ContactOrder order) {
		WebResource resource = baseAPI.getResource("/contact/org/"
				+ organizationId);

		return getContactsCommon(resource, key, value, limit, offset, type,
				order);
	}

	/**
	 * Returns all the profiles of the users contacts on the given space
	 */
	public <T, F, R> List<T> getSpaceContacts(int spaceId,
			ProfileField<F, R> key, F value, Integer limit, Integer offset,
			ProfileType<T> type, ContactOrder order) {
		WebResource resource = baseAPI.getResource("/contact/space/" + spaceId);

		return getContactsCommon(resource, key, value, limit, offset, type,
				order);
	}

	private <T, F, R> List<T> getContactsCommon(WebResource resource,
			ProfileField<F, R> key, F value, Integer limit, Integer offset,
			final ProfileType<T> type, ContactOrder order) {
		if (key != null && value != null) {
			resource = resource.queryParam("key", key.getName().toLowerCase())
					.queryParam("value", key.format(value).toString());
		}
		if (limit != null) {
			resource = resource.queryParam("limit", limit.toString());
		}
		if (offset != null) {
			resource = resource.queryParam("offset", offset.toString());
		}
		resource = resource.queryParam("type", type.getName());
		if (order != null) {
			resource = resource.queryParam("order", order.name().toLowerCase());
		}

		return resource.accept(MediaType.APPLICATION_JSON_TYPE).get(
				getGenericType(type));
	}

	private <T> GenericType<List<T>> getGenericType(final ProfileType<T> type) {
		return new GenericType<List<T>>(new ParameterizedType() {
			@Override
			public Type getRawType() {
				return List.class;
			}

			@Override
			public Type getOwnerType() {
				return null;
			}

			@Override
			public Type[] getActualTypeArguments() {
				return new Type[] { type.getType() };
			}
		});
	}
}
