package com.podio.status;

import javax.ws.rs.core.MediaType;

import com.podio.BaseAPI;
import com.podio.ResourceFactory;

/**
 * Status messages are small texts that the users wishes to share with the other
 * users in a space. It can be anything from a note that the user will be in
 * later today over links to interesting resources and information about what
 * the user is working on a the moment.
 * 
 * Other users can comment on a status message and indicate that they like the
 * status message.
 */
public class StatusAPI extends BaseAPI {

	public StatusAPI(ResourceFactory resourceFactory) {
		super(resourceFactory);
	}

	/**
	 * Creates a new status message for a user on a specific space. A status
	 * update is simply a short text message that the user wishes to share with
	 * the rest of the space.
	 * 
	 * @param status
	 *            The data for the new status message
	 * @return The id of the newly created status message
	 */
	public int createStatus(int spaceId, StatusCreate status) {
		return getResourceFactory()
				.getApiResource("/status/space/" + spaceId + "/")
				.entity(status, MediaType.APPLICATION_JSON_TYPE)
				.post(StatusCreateResponse.class).getId();
	}

	/**
	 * This is used to delete a status message. This is normally only done if
	 * the user regrets his status update. After deletion the status message
	 * will no longer be viewable by anyone.
	 * 
	 * @param statusId
	 *            The id of the status to delete
	 */
	public void deleteStatus(int statusId) {
		getResourceFactory().getApiResource("/status/" + statusId).delete();
	}

	/**
	 * Retrieves a status message by its id. The id of the status message is
	 * usually gotten from the stream.
	 * 
	 * @param statusId
	 *            The id of the status
	 * @return The status message
	 */
	public StatusFull getStatus(int statusId) {
		return getResourceFactory().getApiResource("/status/" + statusId).get(
				StatusFull.class);
	}

	/**
	 * This will update an existing status message. This will normally only be
	 * used to correct spelling and grammatical mistakes.
	 * 
	 * @param statusId
	 *            The id of the status to be updated
	 * @param update
	 *            The new data for the status
	 */
	public void updateStatus(int statusId, StatusUpdate update) {
		getResourceFactory().getApiResource("/status/" + statusId)
				.entity(update, MediaType.APPLICATION_JSON_TYPE).put();
	}
}
