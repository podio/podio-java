package com.podio.contact;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

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
	 * Adds a new contact to the given space.
	 * 
	 * @param spaceId
	 *            The id of the space the contact should be added to
	 * @param create
	 *            The data for the new contact
	 * @param silent
	 *            True if the create should be silent, false otherwise
	 * @return The id of the newly created contact
	 */
	public int addSpaceContact(int spaceId, ContactCreate create, boolean silent) {
		return getResourceFactory().getApiResource("/contact/space/" + spaceId + "/")
				.queryParam("silent", silent ? "1" : "0")
				.entity(create, MediaType.APPLICATION_JSON_TYPE)
				.post(ContactCreateResponse.class).getId();
	}
        
        /**
	 * Updates the entire space contact. Only fields which have values specified 
	 * will be updated. To delete the contents of a field, pass an empty array 
	 * for the value.
	 * 
	 * @param profileId
	 *            The id of the space contact to be updated
	 * @param update
	 *            The data for the update
	 * @param silent
	 *            True if the update should be silent, false otherwise
	 * @param hook
	 *            True if hooks should be executed for the change, false otherwise
	 */
	public void updateSpaceContact(int profileId, ContactUpdate update, boolean silent, boolean hook) {
		getResourceFactory().getApiResource("/contact/" + profileId)
				.queryParam("silent", silent ? "1" : "0")
				.queryParam("hook", hook ? "1" : "0")
				.entity(update, MediaType.APPLICATION_JSON_TYPE).put();
	}
        
        /**
	 * Deletes a space contact.
	 * 
	 * @param profileId
	 *            The id of the space contact to be deleted
         * @param silent
	 *            True if the deletion should be silent, false otherwise
	 */
	public void deleteSpaceContact(int profileId, boolean silent) {
		getResourceFactory().getApiResource("/contact/" + profileId)
                        .queryParam("silent", silent ? "1" : "0")
                        .delete();
	}
        
	/**
	 * Returns all the contact details about the user with the given id.
	 * 
	 * @param profileId
	 *            The profile id of the user
	 * @return The contact profile
	 */
	public Profile getContact(int profileId) {
		return getResourceFactory().getApiResource("/contact/" + profileId + "/v2").get(
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
         * @param contactType
         *            The type of contacts to be returned
	 * @return The list of contacts
	 */
	public <T, F, R> List<T> getContacts(ProfileField<F, R> key, F value,
			Integer limit, Integer offset, ProfileType<T> type,
			ContactOrder order, ContactType contactType) {
		WebResource resource = getResourceFactory().getApiResource("/contact/");

		return getContactsCommon(resource, key, value, limit, offset, type,
				order, contactType);
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
         * @param contactType
         *            The type of contacts to be returned
	 * @return The list of contacts
	 */
	public <T, F, R> List<T> getOrganizationContacts(int organizationId,
			ProfileField<F, R> key, F value, Integer limit, Integer offset,
			ProfileType<T> type, ContactOrder order, ContactType contactType) {
		WebResource resource = getResourceFactory().getApiResource(
				"/contact/org/" + organizationId);

		return getContactsCommon(resource, key, value, limit, offset, type,
				order, contactType);
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
         * @param contactType
         *            The type of contacts to be returned
	 * @return The list of contacts
	 */
	public <T, F, R> List<T> getSpaceContacts(int spaceId,
			ProfileField<F, R> key, F value, Integer limit, Integer offset,
			ProfileType<T> type, ContactOrder order, ContactType contactType) {
		WebResource resource = getResourceFactory().getApiResource(
				"/contact/space/" + spaceId);

		return getContactsCommon(resource, key, value, limit, offset, type,
				order, contactType);
	}
        
        /**
         * Returns the total number of contacts on the space
         * 
         * @param spaceId
         *            The id of the space the number of contacts should be 
         *            returned from
         * @return The total number of space contacts
         */
        public SpaceContactTotals getSpaceContactTotals(int spaceId) {
                return getResourceFactory().getApiResource(
                        "/contact/space/" + spaceId + "/totals/space/").get(
                        SpaceContactTotals.class);
        }

	private <T, F, R> List<T> getContactsCommon(WebResource resource,
			ProfileField<F, R> key, F value, Integer limit, Integer offset,
			final ProfileType<T> type, ContactOrder order, ContactType contactType) {
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
		if (contactType != null) {
			resource = resource.queryParam("contact_type", contactType.name().toLowerCase());
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
