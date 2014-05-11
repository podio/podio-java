package com.podio.contact;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.podio.BaseAPI;
import com.podio.ResourceFactory;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

/**
 * Each user have a profile attached, that holds all the personal details of the
 * user. This includes very basic information like the name and mail addresses,
 * but can also include more advanced fields like billing address and IM
 * addresses. Fields can have either one or multiple values. There can f.ex.
 * only be one name, but multiple mail addresses. The value of a field can
 * either be a string, a number or a date.
 */
public class ContactAPI extends BaseAPI {

	public ContactAPI(ResourceFactory resourceFactory) {
		super(resourceFactory);
	}

	/**
	 * Returns all the contact details about the user with the given id.
	 * 
	 * @param userId
	 *            The id of the user
	 * @return The contact profile
	 */
	public Profile getContact(int userId) {
		return getResourceFactory().getApiResource("/contact/" + userId).get(
				Profile.class);
	}

	/**
	 * Returns the value of a contact with the specific field
	 * 
	 * @param userId
	 *            The id of the user
	 * @param field
	 *            The field for which data should be returned
	 * @return The list of values for the given field
	 */
	public <T, R> List<T> getContactField(int userId, ProfileField<T, R> field) {
		List<R> values = getResourceFactory().getApiResource(
				"/contact/" + userId + "/" + field.getName())

		.get(new GenericType<List<R>>() {
		});

		List<T> formatted = new ArrayList<T>();
		for (R value : values) {
			formatted.add(field.parse(value));
		}

		return formatted;
	}

	/**
	 * Returns the total number of contacts by organization.
	 * 
	 * @return The list of contact totals by organization
	 */
	public ContactTotal getContactTotal() {
		return getResourceFactory().getApiResource("/contact/totals/").get(
				ContactTotal.class);
	}

	/**
	 * Used to get a list of contacts for the user.
	 * 
	 * @param key
	 *            The profile field if the contacts should be filtered
	 * @param value
	 *            The value for the field if the contacts should be filtered
	 * @param limit
	 *            The maximum number of contacts to return
	 * @param offset
	 *            The offset into the list of contacts
	 * @param type
	 *            The format in which the contacts should be returned
	 * @param order
	 *            How the contacts should be ordered
	 * @return The list of contacts
	 */
	public <T, F, R> List<T> getContacts(ProfileField<F, R> key, F value,
			Integer limit, Integer offset, ProfileType<T> type,
			ContactOrder order) {
		WebResource resource = getResourceFactory().getApiResource("/contact/");

		return getContactsCommon(resource, key, value, limit, offset, type,
				order);
	}

	/**
	 * Returns all the profiles of the users contacts on the given organization
	 * 
	 * @param organizationId
	 *            The id of the organization the contacts should be returned
	 *            from
	 * @param key
	 *            The profile field if the contacts should be filtered
	 * @param value
	 *            The value for the field if the contacts should be filtered
	 * @param limit
	 *            The maximum number of contacts to return
	 * @param offset
	 *            The offset into the list of contacts
	 * @param type
	 *            The format in which the contacts should be returned
	 * @param order
	 *            How the contacts should be ordered
	 * @return The list of contacts
	 */
	public <T, F, R> List<T> getOrganizationContacts(int organizationId,
			ProfileField<F, R> key, F value, Integer limit, Integer offset,
			ProfileType<T> type, ContactOrder order) {
		WebResource resource = getResourceFactory().getApiResource(
				"/contact/org/" + organizationId);

		return getContactsCommon(resource, key, value, limit, offset, type,
				order);
	}

	/**
	 * Returns all the profiles of the users contacts on the given space
	 * 
	 * @param spaceId
	 *            The id of the space the contacts should be returned from
	 * @param key
	 *            The profile field if the contacts should be filtered
	 * @param value
	 *            The value for the field if the contacts should be filtered
	 * @param limit
	 *            The maximum number of contacts to return
	 * @param offset
	 *            The offset into the list of contacts
	 * @param type
	 *            The format in which the contacts should be returned
	 * @param order
	 *            How the contacts should be ordered
	 * @return The list of contacts
	 */
	public <T, F, R> List<T> getSpaceContacts(int spaceId,
			ProfileField<F, R> key, F value, Integer limit, Integer offset,
			ProfileType<T> type, ContactOrder order) {
		WebResource resource = getResourceFactory().getApiResource(
				"/contact/space/" + spaceId);

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

		return resource.get(getGenericType(type));
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
