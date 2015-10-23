package com.podio.app;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.podio.BaseAPI;
import com.podio.ResourceFactory;
import com.podio.common.Empty;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

/**
 * This area is used to manage application definitions. An application
 * definition, commonly called just an app, is the setup of an application. It
 * consists primarily of a list of fields and secondly of various settings.
 */
public class AppAPI extends BaseAPI {

	public AppAPI(ResourceFactory resourceFactory) {
		super(resourceFactory);
	}

	/**
	 * Gets the definition of an app and can include configuration and fields.
	 * This method will always return the latest revision of the app definition.
	 * 
	 * @param appId
	 *            The id of the app to be returned
	 * @return The full definition of the app
	 */
	public Application getApp(int appId) {
		return getResourceFactory().getApiResource("/app/" + appId).get(
				Application.class);
	}

	/**
	 * Returns all the apps on the space that are visible. The apps are sorted
	 * by any custom ordering and else by name.
	 * 
	 * @param spaceId
	 *            The id of the space
	 * @return The list of apps on the given space
	 */
	public List<Application> getAppsOnSpace(int spaceId) {
		return getResourceFactory().getApiResource(
				"/app/space/" + spaceId + "/").get(
				new GenericType<List<Application>>() {
				});
	}

	/**
	 * Returns the top apps for the active user. This is the apps that the user
	 * have interacted with the most.
	 * 
	 * @param limit
	 *            The maximum number of apps to return, defaults to 4.
	 * @return The top apps for the active user
	 */
	public List<Application> getTopApps(Integer limit) {
		WebResource resource = getResourceFactory().getApiResource("/app/top/");
		if (limit != null) {
			resource = resource.queryParam("limit", limit.toString());
		}
		return resource.get(new GenericType<List<Application>>() {
		});
	}

	/**
	 * Creates a new app on a space.
	 * 
	 * @param app
	 *            The definition for the new app
	 * @return The id of the newly created app
	 */
	public int addApp(ApplicationCreate app) {
		return getResourceFactory().getApiResource("/app/")
				.entity(app, MediaType.APPLICATION_JSON_TYPE)
				.post(ApplicationCreateResponse.class).getId();
	}

	/**
	 * Updates an app. The update can contain an new configuration for the app,
	 * addition of new fields as well as updates to the configuration of
	 * existing fields. Fields not included will not be deleted. To delete a
	 * field use the "delete field" operation.
	 * 
	 * When adding/updating/deleting apps and fields, it can be simpler to only
	 * update the app config here and add/update/remove fields using the
	 * field/{field_id} sub resource.
	 * 
	 * @param appId
	 *            The id of the app to be updated
	 * @param app
	 *            The updated app definition
	 */
	public void updateApp(int appId, ApplicationUpdate app) {
		getResourceFactory().getApiResource("/app/" + appId)
				.entity(app, MediaType.APPLICATION_JSON).put();
	}

	/**
	 * Adds a new field to an app
	 * 
	 * @param appId
	 *            The id of the the field should be added to
	 * @param field
	 *            The definition of the new field
	 * @return The id of the newly created field
	 */
	public int addField(int appId, ApplicationFieldCreate field) {
		return getResourceFactory().getApiResource("/app/" + appId + "/field/")
				.entity(field, MediaType.APPLICATION_JSON_TYPE)
				.post(ApplicationFieldCreateResponse.class).getId();
	}

	/**
	 * Updates the configuration of an app field. The type of the field cannot
	 * be updated, only the configuration.
	 * 
	 * @param appId
	 *            The id of the app the field is one
	 * @param fieldId
	 *            The id of the field to be updated
	 * @param configuration
	 *            The new configuration of the field
	 */
	public void updateField(int appId, int fieldId,
			ApplicationFieldConfiguration configuration) {
		getResourceFactory()
				.getApiResource("/app/" + appId + "/field/" + fieldId)
				.entity(configuration, MediaType.APPLICATION_JSON_TYPE).put();
	}

	/**
	 * Returns a single field from an app.
	 * 
	 * @param appId
	 *            The id of the app the field is on
	 * @param fieldId
	 *            The id of the field to be returned
	 * @return The definition and current configuration of the requested field
	 */
	public ApplicationField getField(int appId, int fieldId) {
		return getResourceFactory().getApiResource(
				"/app/" + appId + "/field/" + fieldId).get(
				ApplicationField.class);
	}

	/**
	 * Returns a single field from an app.
	 * 
	 * @param appId
	 *            The id of the app the field is on
	 * @param externalId
	 *            The id of the field to be returned
	 * @return The definition and current configuration of the requested field
	 */
	public ApplicationField getField(int appId, String externalId) {
		return getResourceFactory().getApiResource(
				"/app/" + appId + "/field/" + externalId).get(
				ApplicationField.class);
	}

	/**
	 * Deletes a field on an app. When deleting a field any new items and
	 * updates to existing items will not have this field present. For existing
	 * items, the field will still be presented when viewing the item.
	 * 
	 * @param appId
	 *            The id of the app the field is on
	 * @param fieldId
	 *            The id of the field that should be deleted
	 */
	public void deleteField(int appId, int fieldId) {
		getResourceFactory().getApiResource(
				"/app/" + appId + "/field/" + fieldId).delete();
	}

	/**
	 * Installs the app with the given id on the space.
	 * 
	 * @param appId
	 *            The id of the app to be installed
	 * @param spaceId
	 *            The id of the space the app should be installed o n
	 * @return The id of the newly installed app
	 */
	public int install(int appId, int spaceId) {
		return getResourceFactory()
				.getApiResource("/app/" + appId + "/install")
				.entity(new ApplicationInstall(spaceId),
						MediaType.APPLICATION_JSON_TYPE)
				.post(ApplicationCreateResponse.class).getId();
	}

	/**
	 * Updates the order of the apps on the space. It should post all the apps
	 * from the space in the order required.
	 * 
	 * @param spaceId
	 *            The id of the space the apps are on
	 * @param appIds
	 *            The ids of the apps in the new order
	 */
	public void updateOrder(int spaceId, List<Integer> appIds) {
		getResourceFactory().getApiResource("/app/space/" + spaceId + "/order")
				.entity(appIds, MediaType.APPLICATION_JSON_TYPE).put();
	}

	/**
	 * Returns the apps available to the user.
	 * 
	 * @return The list of apps the user has access to
	 */
	public List<Application> getApps() {
		return getResourceFactory().getApiResource("/app/v2/").get(
				new GenericType<List<Application>>() {
				});
	}

	/**
	 * Returns the apps that the given app depends on.
	 * 
	 * @param appId
	 *            The id of the app the dependecies should be returned for
	 * @return The applications that the given app depends on
	 */
	public Dependencies getDependencies(int appId) {
		return getResourceFactory().getApiResource(
				"/app/" + appId + "/dependencies/").get(Dependencies.class);
	}

	/**
	 * Deactivates the app with the given id. This removes the app from the app
	 * navigator, and disables insertion of new items.
	 * 
	 * @param appId
	 *            The id of the app to deactivate
	 */
	public void deactivateApp(int appId) {
		getResourceFactory().getApiResource("/app/" + appId + "/deactivate")
				.entity(new Empty(), MediaType.APPLICATION_JSON_TYPE).post();
	}

	/**
	 * Activates a deactivated app. This puts the app back in the app navigator
	 * and allows insertion of new items.
	 * 
	 * @param appId
	 *            The id of the app to activate
	 */
	public void activateApp(int appId) {
		getResourceFactory().getApiResource("/app/" + appId + "/activate")
				.entity(new Empty(), MediaType.APPLICATION_JSON_TYPE).post();
	}

	/**
	 * Deletes the app with the given id. This will delete all items, widgets,
	 * filters and shares on the app. This operating is not reversible.
	 * 
	 * @param appId
	 *            The id of the app to delete
	 */
	public void deleteApp(int appId) {
		getResourceFactory().getApiResource("/app/" + appId).delete();
	}
}
