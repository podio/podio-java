package com.podio.space;

import javax.ws.rs.core.MediaType;

import com.podio.BaseAPI;

public class SpaceAPI {

	private final BaseAPI baseAPI;

	public SpaceAPI(BaseAPI baseAPI) {
		this.baseAPI = baseAPI;
	}

	/**
	 * Add a new space to an organization.
	 * 
	 * @param data
	 *            The data for the new space
	 * @return The data about the new created space
	 */
	public SpaceCreateResponse createSpace(SpaceCreate data) {
		return baseAPI.getApiResource("/space/")
				.entity(data, MediaType.APPLICATION_JSON_TYPE)
				.post(SpaceCreateResponse.class);
	}

	/**
	 * Get the space with the given id
	 * 
	 * @param spaceId
	 *            The id of the space
	 * @return The space with the given id
	 */
	public Space getSpace(int spaceId) {
		return baseAPI.getApiResource("/space/" + spaceId)
				.accept(MediaType.APPLICATION_JSON_TYPE).get(Space.class);
	}

	/**
	 * Updates the space with the given id
	 * 
	 * @param spaceId
	 *            The id of the space to update
	 * @param data
	 *            The updated data of the space
	 */
	public void updateSpace(int spaceId, SpaceUpdate data) {
		baseAPI.getApiResource("/space/" + spaceId)
				.entity(data, MediaType.APPLICATION_JSON_TYPE).put();
	}

	/**
	 * Returns the space and organization with the given full URL.
	 * 
	 * @param url
	 *            The full URL of the space
	 * @return The space with organization
	 */
	public SpaceWithOrganization getSpaceByURL(String url) {
		return baseAPI.getApiResource("/space/url").queryParam("url", url)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(SpaceWithOrganization.class);
	}

	/**
	 * Invites a list of users (either through user_id or email) to the space.
	 * If the user limit is reached, status code 403 will be returned.
	 * 
	 * @param invitation
	 *            The data of the invitations
	 */
	public void inviteToSpace(int spaceId, SpaceInvitation invitation) {
		baseAPI.getApiResource("/space/" + spaceId + "/invite")
				.entity(invitation, MediaType.APPLICATION_JSON_TYPE).post();
	}

	/**
	 * Returns the statistics for the space with the number of members,
	 * statuses, items and comments.
	 * 
	 * @param spaceId
	 *            The id of the space
	 * @return The statistics for the space
	 */
	public SpaceStatistics getSpaceStatistics(int spaceId) {
		return baseAPI.getApiResource("/space/" + spaceId + "/statistics")
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(SpaceStatistics.class);
	}

	/**
	 * Used to get the details of an active users membership of a space.
	 * 
	 * @param spaceId
	 *            The id of the space
	 * @param userId
	 *            The ud of the user
	 * @return The details about the space membership
	 */
	public SpaceMember getSpaceMembership(int spaceId, int userId) {
		return baseAPI
				.getApiResource("/space/" + spaceId + "/member/" + userId)
				.accept(MediaType.APPLICATION_JSON_TYPE).get(SpaceMember.class);
	}
}
