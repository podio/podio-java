package com.podio.space;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

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
	 * Adds a list of users (either through user_id or email) to the space.
	 * 
	 * @param spaceId
	 *            The id of the space
	 * @param spaceMemberAdd
	 *            Information about the user(s) to add
	 */
	public void addSpaceMembers(int spaceId, SpaceMemberAdd spaceMemberAdd) {
		getResourceFactory()
				.getApiResource("/space/" + spaceId + "/member/")
				.entity(spaceMemberAdd,	MediaType.APPLICATION_JSON_TYPE)
				.post();
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
	 * Returns the active members of the given space ("v2").
	 * 
	 * @param spaceId
	 *            The id of the space
	 * @param offset
	 *            The offset into the user list
	 * @param limit
	 *            The number of results to return (max 500)
	 * @return The active members of the space
	 */
	public List<SpaceMemberV2> getActiveMembersV2(int spaceId, int offset, int limit) {
		return getResourceFactory()
		           .getApiResource("/space/" + spaceId + "/member/v2/")
		           .queryParam("offset", new Integer(offset).toString())
		           .queryParam("limit", new Integer(limit).toString())
		           .get(new GenericType<List<SpaceMemberV2>>() { });
	}
	
	/**
	 * Returns the active members of the given space ("v2").
	 * 
	 * @param spaceId
	 *            The id of the space
	 * @param options
	 *            The parameters for get space members v2 
	 * @return The active members of the space
	 */
	public List<SpaceMemberV2> getActiveMembersV2(int spaceId, MultivaluedMap<String, String> options) {
		return getResourceFactory()
		           .getApiResource("/space/" + spaceId + "/member/v2/")
		           .queryParams(options)
		           .get(new GenericType<List<SpaceMemberV2>>() { });
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
