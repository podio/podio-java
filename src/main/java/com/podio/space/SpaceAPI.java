package com.podio.space;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.podio.BaseAPI;
import com.podio.ResourceFactory;
import com.podio.common.Role;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

public class SpaceAPI extends BaseAPI {

	public SpaceAPI(ResourceFactory resourceFactory) {
		super(resourceFactory);
	}

	/**
	 * Add a new space to an organization.
	 * 
	 * @param data
	 *            The data for the new space
	 * @return The data about the new created space
	 */
	public SpaceCreateResponse createSpace(SpaceCreate data) {
		return getResourceFactory().getApiResource("/space/")
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
		return getResourceFactory().getApiResource("/space/" + spaceId).get(
				Space.class);
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
		getResourceFactory().getApiResource("/space/" + spaceId)
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
		return getResourceFactory().getApiResource("/space/url")
				.queryParam("url", url).get(SpaceWithOrganization.class);
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
		return getResourceFactory().getApiResource(
				"/space/" + spaceId + "/statistics").get(SpaceStatistics.class);
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
		return getResourceFactory().getApiResource(
				"/space/" + spaceId + "/member/" + userId).get(
				SpaceMember.class);
	}

	/**
	 * Updates a space membership with another role
	 * 
	 * @param spaceId
	 *            The id of the space
	 * @param userId
	 *            The id of the user
	 * @param role
	 *            The new role for the membership
	 */
	public void updateSpaceMembership(int spaceId, int userId, Role role) {
		getResourceFactory()
				.getApiResource("/space/" + spaceId + "/member/" + userId)
				.entity(new SpaceMemberUpdate(role),
						MediaType.APPLICATION_JSON_TYPE).put();
	}

	/**
	 * Ends the users membership on the space, can also be called for members in
	 * state invited.
	 * 
	 * @param spaceId
	 *            The id of the space
	 * @param userId
	 *            The id of the user
	 */
	public void endSpaceMembership(int spaceId, int userId) {
		getResourceFactory().getApiResource(
				"/space/" + spaceId + "/member/" + userId).delete();
	}

	/**
	 * Returns the active members of the given space.
	 * 
	 * @param spaceId
	 *            The id of the space
	 * @return The active members of the space
	 */
	public List<SpaceMember> getActiveMembers(int spaceId) {
		return getResourceFactory().getApiResource(
				"/space/" + spaceId + "/member/").get(
				new GenericType<List<SpaceMember>>() {
				});
	}

	/**
	 * Returns a list of the members that have been removed from the space.
	 * 
	 * @param spaceId
	 *            The id of the space
	 * @return The active members of the space
	 */
	public List<SpaceMember> getEndedMembers(int spaceId) {
		return getResourceFactory().getApiResource(
				"/space/" + spaceId + "/member/ended/").get(
				new GenericType<List<SpaceMember>>() {
				});
	}

	/**
	 * Returns the top most active members of the space.
	 * 
	 * @param spaceId
	 *            The id of the space
	 * @param limit
	 *            The max number of members to return, defaults to 6
	 * @return The top users for the space
	 */
	public SpaceTopMembers getTopUsers(int spaceId, Integer limit) {
		WebResource resource = getResourceFactory().getApiResource(
				"/space/" + spaceId + "/member/top/");
		if (limit != null) {
			resource = resource.queryParam("limit", limit.toString());
		}

		return resource.get(SpaceTopMembers.class);
	}

	/**
	 * Returns the top spaces for the user
	 * 
	 * @param limit
	 *            The max number of members to return, defaults to 6
	 * @return The top spaces for the user
	 */
	public List<SpaceWithOrganization> getTopSpaces(Integer limit) {
		WebResource resource = getResourceFactory().getApiResource(
				"/space/top/");
		if (limit != null) {
			resource = resource.queryParam("limit", limit.toString());
		}

		return resource.get(new GenericType<List<SpaceWithOrganization>>() {
		});
	}
}
