package com.podio.status;

import javax.ws.rs.core.MediaType;

import com.podio.BaseAPI;

/**
 * Status messages are small texts that the users wishes to share with the other
 * users in a space. It can be anything from a note that the user will be in
 * later today over links to interesting resources and information about what
 * the user is working on a the moment.
 * 
 * Other users can comment on a status message and indicate that they like the
 * status message.
 */
public class StatusAPI {

	private final BaseAPI baseAPI;

	public StatusAPI(BaseAPI baseAPI) {
		this.baseAPI = baseAPI;
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
		return baseAPI.getApiResource("/status/space/" + spaceId + "/")
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
		baseAPI.getApiResource("/status/" + statusId)
				.accept(MediaType.APPLICATION_JSON_TYPE).delete();
	}

	/**
	 * Retrieves the latest status message on a space from a user. This is
	 * usually displayed on profile pages.
	 * 
	 * @param userId
	 *            The id of the user
	 * @param spaceId
	 *            The id of the space
	 * @return The latest status message
	 */
	public Status getLatestStatus(int userId, int spaceId) {
		return baseAPI
				.getApiResource(
						"/status/user/" + userId + "/space/" + spaceId
								+ "/latest/")
				.accept(MediaType.APPLICATION_JSON_TYPE).get(Status.class);
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
		return baseAPI.getApiResource("/status/" + statusId)
				.accept(MediaType.APPLICATION_JSON_TYPE).get(StatusFull.class);
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
		baseAPI.getApiResource("/status/" + statusId)
				.entity(update, MediaType.APPLICATION_JSON_TYPE).put();
	}
}
