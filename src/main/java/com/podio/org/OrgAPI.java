package com.podio.org;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.podio.ResourceFactory;
import com.podio.space.Space;
import com.sun.jersey.api.client.GenericType;

public class OrgAPI {

	private final ResourceFactory resourceFactory;

	public OrgAPI(ResourceFactory resourceFactory) {
		this.resourceFactory = resourceFactory;
	}

	/**
	 * Creates a new organization
	 * 
	 * @param data
	 *            The data for the new organization
	 * @return The data for the newly created organization
	 */
	public OrganizationCreateResponse createOrganization(OrganizationCreate data) {
		return resourceFactory.getApiResource("/org/")
				.entity(data, MediaType.APPLICATION_JSON_TYPE)
				.post(OrganizationCreateResponse.class);
	}

	/**
	 * Updates an organization with new name and logo. Note that the URL of the
	 * organization will not change even though the name changes.
	 * 
	 * @param orgId
	 *            The id of the organization
	 * @param data
	 *            The new data
	 */
	public void updateOrganization(int orgId, OrganizationCreate data) {
		resourceFactory.getApiResource("/org/" + orgId)
				.entity(data, MediaType.APPLICATION_JSON_TYPE).put();
	}

	/**
	 * Gets the organization with the given id.
	 * 
	 * @param orgId
	 *            The id of the organization
	 * @return The organization
	 */
	public Organization getOrganization(int orgId) {
		return resourceFactory.getApiResource("/org/" + orgId).get(
				Organization.class);
	}

	/**
	 * Deletes the organization with the given id. This will also delete all
	 * spaces under the organization (see the delete space operation for
	 * details)
	 * 
	 * @param orgId
	 *            The id of the organization
	 */
	public void deleteOrganization(int orgId) {
		resourceFactory.getApiResource("/org/" + orgId).delete();
	}

	/**
	 * Returns a list of all the organizations and spaces the user is member of.
	 * 
	 * @return The organizations the user is member of
	 */
	public List<OrganizationWithSpaces> getOrganizations() {
		return Arrays.asList(resourceFactory.getApiResource("/org/").get(
				OrganizationWithSpaces[].class));
	}

	/**
	 * Returns the organization with the given full URL. The URL does not have
	 * to be truncated to the root, it can be to any resource on the URL.
	 * 
	 * @param url
	 *            The URL to find the organization for
	 * @return The organization
	 */
	public OrganizationMini getOrganizationByURL(String url) {
		return resourceFactory.getApiResource("/org/url")
				.queryParam("url", url).get(OrganizationMini.class);
	}

	/**
	 * Returns interesting statistics for this organization. Only org creator is
	 * allowed to see this.
	 * 
	 * @param orgId
	 *            The id of the organization
	 * @return The statistics
	 */
	public OrganizationStatistics getOrganizationStatistics(int orgId) {
		return resourceFactory.getApiResource("/org/" + orgId + "/statistics")
				.get(OrganizationStatistics.class);
	}

	/**
	 * Returns the organizations and spaces that the logged in user shares with
	 * the specified user. The organizations and spaces will be returned sorted
	 * by name.
	 * 
	 * @param userId
	 *            The id of the user
	 * @return The organizations with spaces that are shared with the user
	 */
	public List<OrganizationWithSpaces> getSharedOrganizations(int userId) {
		return resourceFactory.getApiResource("/org/shared/" + userId).get(
				new GenericType<List<OrganizationWithSpaces>>() {
				});
	}

	/**
	 * Return the space with the given URL on the space. To get the space
	 * related to http://company.podio.com/intranet, first lookup the
	 * organization on "company" and then the space using this function using
	 * the URL "intranet".
	 * 
	 * @param orgId
	 *            The id of the organization
	 * @param url
	 *            The url fragment for the space
	 * @return The matching space
	 */
	public Space getSpaceByURL(int orgId, String url) {
		return resourceFactory.getApiResource(
				"/org/" + orgId + "/space/url/" + url).get(Space.class);
	}

	/**
	 * Returns all the spaces for the organization.
	 * 
	 * @param orgId
	 *            The id of the organization
	 * @return The spaces in the organization
	 */
	public List<Space> getSpaces(int orgId) {
		return resourceFactory.getApiResource("/org/" + orgId + "/space/").get(
				new GenericType<List<Space>>() {
				});
	}
}
