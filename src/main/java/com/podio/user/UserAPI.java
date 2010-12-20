package com.podio.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.podio.ResourceFactory;
import com.podio.contact.Profile;
import com.podio.contact.ProfileField;
import com.podio.contact.ProfileFieldValues;
import com.podio.contact.ProfileUpdate;
import com.sun.jersey.api.client.GenericType;

/**
 * This area holds all the users which just includes basic operations.
 */
public class UserAPI {

	private final ResourceFactory resourceFactory;

	public UserAPI(ResourceFactory resourceFactory) {
		this.resourceFactory = resourceFactory;
	}

	/**
	 * Updates the active user. The old and new password can be left out, in
	 * which case the password will not be changed. If the mail is changed, the
	 * old password has to be supplied as well.
	 */
	public void updateUser(UserUpdate update) {
		resourceFactory.getApiResource("/user/")
				.entity(update, MediaType.APPLICATION_JSON_TYPE).put();
	}

	/**
	 * Returns the current status for the user. This includes the user data,
	 * profile data and notification data.
	 * 
	 * @return The status of the user
	 */
	public UserStatus getStatus() {
		return resourceFactory.getApiResource("/user/status").get(
				UserStatus.class);
	}

	/**
	 * Returns the profile of the active user
	 * 
	 * @return The profile for the user
	 */
	public Profile getProfile() {
		return resourceFactory.getApiResource("/user/profile/").get(
				Profile.class);
	}

	/**
	 * Returns the field of the profile for the given key from the active user.
	 * 
	 * @param field
	 *            The field to return the values for
	 * @return The values for the given field
	 */
	public <T, R> List<T> getProfileField(ProfileField<T, R> field) {
		List<R> values = resourceFactory.getApiResource(
				"/user/profile/" + field.getName()).get(
				new GenericType<List<R>>() {
				});

		List<T> formatted = new ArrayList<T>();
		for (R value : values) {
			formatted.add(field.parse(value));
		}

		return formatted;
	}

	/**
	 * Updates the fields of an existing profile. All fields must be filled out,
	 * as any fields not included will not be part of the new revision.
	 * 
	 * @param profile
	 *            The updated profile
	 */
	public void updateProfile(ProfileUpdate profile) {
		resourceFactory.getApiResource("/user/profile/")
				.entity(profile, MediaType.APPLICATION_JSON_TYPE).put();
	}

	/**
	 * Updates a single field on the profile of the user
	 * 
	 * @param field
	 *            The field that should be updated
	 * @param value
	 *            The new value of the field
	 */
	public <F> void updateProfileField(ProfileField<F, ?> field, F value) {
		if (field.isSingle()) {
			resourceFactory
					.getApiResource("/user/profile/" + field.getName())
					.entity(new ProfileFieldSingleValue<F>(value),
							MediaType.APPLICATION_JSON_TYPE).put();
		} else {
			resourceFactory
					.getApiResource("/user/profile/" + field.getName())
					.entity(new ProfileFieldMultiValue<F>(value),
							MediaType.APPLICATION_JSON_TYPE).put();
		}
	}

	/**
	 * Updates a single field on the profile of the user
	 * 
	 * @param field
	 *            The field that should be updated
	 * @param values
	 *            The new values of the field
	 */
	public <F> void updateProfileField(ProfileField<F, ?> field, F... values) {
		updateProfileField(field, Arrays.asList(values));
	}

	/**
	 * Updates a single field on the profile of the user
	 * 
	 * @param field
	 *            The field that should be updated
	 * @param values
	 *            The new values of the field
	 */
	public <F> void updateProfileField(ProfileField<F, ?> field, List<F> values) {
		if (field.isSingle()) {
			throw new IllegalArgumentException(
					"Field is only valid for single value");
		} else {
			resourceFactory
					.getApiResource("/user/profile/" + field.getName())
					.entity(new ProfileFieldMultiValue<F>(values),
							MediaType.APPLICATION_JSON_TYPE).put();
		}
	}

	/**
	 * Updates the fields of an existing profile. Will only update the fields in
	 * the values.
	 * 
	 * @param values
	 *            The updated values for the profile
	 */
	public void updateProfile(ProfileFieldValues values) {
		resourceFactory.getApiResource("/user/profile/")
				.entity(values, MediaType.APPLICATION_JSON_TYPE).put();
	}

	/**
	 * Gets the active user
	 * 
	 * @return The active user
	 */
	public User getUser() {
		return resourceFactory.getApiResource("/user/").get(User.class);
	}

	/**
	 * Returns the user with given mail address.
	 * 
	 * @param mail
	 *            The mail address of the user
	 * @return The user with the given mail address
	 */
	public User getUserByMail(String mail) {
		return resourceFactory.getApiResource("/user/" + mail).get(User.class);
	}

	/**
	 * Returns the value of the property for the active user with the given
	 * name. The property is specific to the auth client used.
	 * 
	 * @param key
	 *            The key of the property
	 */
	public boolean getProperty(String key) {
		return resourceFactory.getApiResource("/user/property/" + key)
				.get(PropertyValue.class).getValue();
	}

	/**
	 * Sets the value of the property for the active user with the given name.
	 * The property is specific to the auth client used.
	 * 
	 * @param key
	 *            The key of the property
	 * @param value
	 *            The value of the property
	 */
	public void setProperty(String key, boolean value) {
		resourceFactory
				.getApiResource("/user/property/" + key)
				.entity(new PropertyValue(value),
						MediaType.APPLICATION_JSON_TYPE).put();
	}

	/**
	 * Deletes the property for the active user with the given name. The
	 * property is specific to the auth client used.
	 * 
	 * @param key
	 *            The key of the property that should be deleted
	 */
	public void deleteProperty(String key) {
		resourceFactory.getApiResource("/user/property/" + key).delete();
	}
}
