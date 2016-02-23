package com.podio.item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import com.podio.BaseAPI;
import com.podio.ResourceFactory;
import com.podio.common.ToStringUtil;
import com.podio.filter.ExternalIdFilterBy;
import com.podio.filter.FilterByValue;
import com.podio.filter.SortBy;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

/**
 * Items are entries in an app. If you think of app as a table, items will be
 * the rows in the table. Items consists of some basic information as well
 * values for each of the fields in the app. For each field there can be
 * multiple values (F.ex. there can be multiple links to another app) and
 * multiple types of values (F.ex. a field of type date field consists of both a
 * start date and an optional end date). The type is denoted by an string id
 * called a sub_id. Most types of fields have only one type, which is denoted by
 * the sub_id values. Others have multiple sub_ids.
 */
public class ItemAPI extends BaseAPI {
	
	public class PaginatePodio 
	{
		public int limit = 50;
	}
	
	public ItemAPI(ResourceFactory resourceFactory) {
		super(resourceFactory);
	}

	/**
	 * Adds a new item to the given app.
	 * 
	 * @param appId
	 *            The id of the app the item should be added to
	 * @param create
	 *            The data for the new item
	 * @param silent
	 *            True if the create should be silten, false otherwise
	 * @return The id of the newly created item
	 */
	public int addItem(int appId, ItemCreate create, boolean silent) {
		return getResourceFactory().getApiResource("/item/app/" + appId + "/")
				.queryParam("silent", silent ? "1" : "0")
				.entity(create, MediaType.APPLICATION_JSON_TYPE)
				.post(ItemCreateResponse.class).getId();
	}

	/**
	 * Gets the item with the given id
	 * 
	 * @param itemId
	 *            The id of the item
	 * @return The item with given id
	 */
	public Item getItem(int itemId) {
		return getResourceFactory().getApiResource("/item/" + itemId).get(
				Item.class);
	}

	/**
	 * Updates the entire item. Only fields which have values specified will be
	 * updated. To delete the contents of a field, pass an empty array for the
	 * value.
	 * 
	 * @param itemId
	 *            The id of the item to update
	 * @param update
	 *            The data for the update
	 * @param silent
	 *            True if the update should be silent, false otherwise
	 * @param hook
	 *            True if hooks should be executed for the change, false otherwise
	 */
	public void updateItem(int itemId, ItemUpdate update, boolean silent, boolean hook) {
		getResourceFactory().getApiResource("/item/" + itemId)
				.queryParam("silent", silent ? "1" : "0")
				.queryParam("hook", hook ? "1" : "0")
				.entity(update, MediaType.APPLICATION_JSON_TYPE).put();
	}

	/**
	 * Updates all the values for an item
	 * 
	 * @param itemId
	 *            The id of the item
	 * @param values
	 *            The values for the fields
	 * @param silent
	 *            True if the update should be silent, false otherwise
	 * @param hook
	 *            True if hooks should be executed for the change, false otherwise
	 */
	public void updateItemValues(int itemId, List<FieldValuesUpdate> values,
			boolean silent, boolean hook) {
		getResourceFactory().getApiResource("/item/" + itemId + "/value/")
				.queryParam("silent", silent ? "1" : "0")
				.queryParam("hook", hook ? "1" : "0")
				.entity(values, MediaType.APPLICATION_JSON_TYPE).put();
	}

	/**
	 * Update the item values for a specific field.
	 * 
	 * @param itemId
	 *            The id of the item
	 * @param fieldId
	 *            The id of the field
	 * @param values
	 *            The new values for the field
	 * @param silent
	 *            True if the update should be silent, false otherwise
	 * @param hook
	 *            True if hooks should be executed for the change, false otherwise
	 */
	public void updateItemFieldValues(int itemId, int fieldId,
			List<Map<String, Object>> values, boolean silent, boolean hook) {
		getResourceFactory()
				.getApiResource("/item/" + itemId + "/value/" + fieldId)
				.queryParam("silent", silent ? "1" : "0")
				.queryParam("hook", hook ? "1" : "0")
				.entity(values, MediaType.APPLICATION_JSON_TYPE).put();
	}

	/**
	 * Deletes an item and removes it from all views. The data can no longer be
	 * retrieved.
	 * 
	 * @param itemId
	 *            The id of the item
	 * @param silent
	 *            True if the deletion should be silent, false otherwise
	 */
	public void deleteItem(int itemId, boolean silent) {
		getResourceFactory().getApiResource("/item/" + itemId)
				.queryParam("silent", silent ? "1" : "0").delete();
	}

	/**
	 * Returns the values for a specified field on an item
	 * 
	 * @param itemId
	 *            The id of the item
	 * @param fieldId
	 *            The id of the field
	 * @return The values on the field on the item
	 */
	public List<Map<String, Object>> getItemFieldValues(int itemId, int fieldId) {
		return getResourceFactory().getApiResource(
				"/item/" + itemId + "/value/" + fieldId).get(
				new GenericType<List<Map<String, Object>>>() {
				});
	}

	/**
	 * Returns all the values for an item, with the additional data provided by
	 * the get item operation.
	 * 
	 * @param itemId
	 *            The id of the item
	 * @return The values on the item
	 */
	public List<FieldValuesView> getItemValues(int itemId) {
		return getResourceFactory().getApiResource(
				"/item/" + itemId + "/value/").get(
				new GenericType<List<FieldValuesView>>() {
				});
	}

	/**
	 * Used to find possible items for a given application field. It searches
	 * the relevant items for the title given.
	 * 
	 * @param fieldId
	 *            The id of app reference field to search for
	 * @param text
	 *            The text to search for in the items title
	 * @param notItemIds
	 *            If supplied the items with these ids will not be returned
	 * @param limit
	 *            The maximum number of results to return. Default value: 13
	 * @return The items that were valid for the field and with text matching
	 */
	public List<ItemMini> getItemsByFieldAndTitle(int fieldId, String text,
												List<Integer> notItemIds, Integer limit) {
		WebResource resource = getResourceFactory().getApiResource(
			"/item/field/" + fieldId + "/find");

		if (limit != null) {
			resource = resource.queryParam("limit", limit.toString());
		}

		if (notItemIds != null && notItemIds.size() > 0) {
			resource = resource.queryParam(
				"not_item_id", ToStringUtil.toString(notItemIds, ","));
		}

		resource = resource.queryParam("text", text);
		return resource.get(new GenericType<List<ItemMini>>() {});
	}

	/**
	 * Returns the items that have a reference to the given item. The references
	 * are grouped by app. Both the apps and the items are sorted by title.
	 * 
	 * @param itemId
	 *            The id of the item
	 * @return The references to the given item
	 */
	public List<ItemReference> getItemReference(int itemId) {
		return getResourceFactory().getApiResource(
				"/item/" + itemId + "/reference/").get(
				new GenericType<List<ItemReference>>() {
				});
	}

	/**
	 * Returns the data about the specific revision on an item
	 * 
	 * @param itemId
	 *            The id of the item
	 * @param revisionId
	 *            The running revision number, starts at 0 for the initial
	 *            revision
	 * @return The revision
	 */
	public ItemRevision getItemRevision(int itemId, int revisionId) {
		return getResourceFactory().getApiResource(
				"/item/" + itemId + "/revision/" + revisionId).get(
				ItemRevision.class);
	}

	/**
	 * Returns the difference in fields values between the two revisions.
	 * 
	 * @param itemId
	 *            The id of the item
	 * @param revisionFrom
	 *            The from revision
	 * @param revisionTo
	 *            The to revision
	 * @return The difference between the two revision
	 */
	public List<ItemFieldDifference> getItemRevisionDifference(int itemId,
			int revisionFrom, int revisionTo) {
		return getResourceFactory().getApiResource(
				"/item/" + itemId + "/revision/" + revisionFrom + "/"
						+ revisionTo).get(
				new GenericType<List<ItemFieldDifference>>() {
				});
	}

	/**
	 * Returns all the revisions that have been made to an item
	 * 
	 * @param itemId
	 *            The id of the item
	 * @return All the revisions
	 */
	public List<ItemRevision> getItemRevisions(int itemId) {
		return getResourceFactory().getApiResource(
				"/item/" + itemId + "/revision/").get(
				new GenericType<List<ItemRevision>>() {
				});
	}

	/**
	 * Returns the items on app matching the given filters.
	 * 
	 * @param appId
	 *            The id of the app
	 * @param limit
	 *            The maximum number of items to receive, defaults to 20
	 * @param offset
	 *            The offset from the start of the items returned, defaults to 0
	 * @param sortBy
	 *            How the items should be sorted. For the possible options, see
	 *            the filter area.
	 * @param sortDesc
	 *            <code>true</code> or leave out to sort descending, use
	 *            <code>false</code> to sort ascending
	 * @param filters
	 *            The filters to apply
	 * @return The items matching the filters
	 */
	public ItemsResponse getItems(int appId, Integer limit, Integer offset,
			SortBy sortBy, Boolean sortDesc, FilterByValue<?>... filters) {
		WebResource resource = getResourceFactory().getApiResource(
				"/item/app/" + appId + "/filter/");
		Map<String, Object> object = new HashMap<String, Object>();
		if (limit != null) {
			object.put("limit", limit);
		}
		if (offset != null) {
			object.put("offset", offset);
		}
		if (sortBy != null) {
			object.put("sort_by", sortBy);
		}
		if (sortDesc != null) {
			object.put("sort_desc", sortDesc);
		}
		Map<String, Object> filterMap = new HashMap<String, Object>();
		for (FilterByValue<?> filter : filters) {
			filterMap.put(filter.getBy().getKey(), filter.getFormattedValue());
		}
		if (filterMap.size() > 0)
		{
			object.put("filters", filterMap);
		}
		
		return resource.entity(object, MediaType.APPLICATION_JSON_TYPE)
				.post(ItemsResponse.class);
	}

	/**
	 * Utility method to get items matching an external id
	 * 
	 * @param appId
	 *            The id of the app
	 * @param externalId
	 *            The external id
	 * @return The items matching the app and external id
	 */
	public ItemsResponse getItemsByExternalId(int appId, String externalId) {
		return getItems(appId, null, null, null, null,
				new FilterByValue<String>(new ExternalIdFilterBy(), externalId));
	}
	
	/**
	 * Returns the items on app for a given view
	 *
	 * @param appId
	 *            The id of the app
	 * @param viewId
	 * 			  The id of the view
	 * @param limit
	 *            The maximum number of items to receive, defaults to 20
	 * @param offset
	 *            The offset from the start of the items returned, defaults to 0
	 * @param sortBy
	 *            How the items should be sorted. For the possible options, see
	 *            the filter area.
	 * @param sortDesc
	 *            <code>true</code> or leave out to sort descending, use
	 *            <code>false</code> to sort ascending
	 * @param filters
	 *            The filters to apply
	 * @return The items matching the filters
	 */
	public ItemsResponse getItemsByView(int appId, int viewId, Integer limit, Integer offset,
			SortBy sortBy, Boolean sortDesc, FilterByValue<?>... filters) {
		WebResource resource = getResourceFactory().getApiResource(
				"/item/app/" + appId + "/filter/" + viewId + "/");
		Map<String, Object> object = new HashMap<String, Object>();
		if (limit != null) {
			object.put("limit", limit);
		}
		if (offset != null) {
			object.put("offest", offset);
		}
		if (sortBy != null) {
			object.put("sort_by", sortBy);
		}
		if (sortDesc != null) {
			object.put("sort_desc", sortDesc);
		}
		Map<String, Object> filterMap = new HashMap<String, Object>();
		for (FilterByValue<?> filter : filters) {
			filterMap.put(filter.getBy().getKey(), filter.getFormattedValue());
		}		
		object.put("filters", filterMap);
		
		return resource.entity(object, MediaType.APPLICATION_JSON_TYPE)
				.post(ItemsResponse.class);
	}
	
	/**
	 * Returns the items on app for a given view
	 *
	 * @param appId
	 *            The id of the app
	 * @return the item count
	 */
	public ItemCount getItemCount(int appId )
	{
		WebResource resource = getResourceFactory().getApiResource(
				"/item/app/" + appId + "/count");
		return resource.get( ItemCount.class );
	}
	
	/**
	 * Returns the items on app for a given view
	 *
	 * @param appId
	 *            The id of the app
	 * @param viewId
	 * 			  The id of the view
	 * @return the item count
	 */
	public ItemCount getItemCount(int appId, Integer viewId) {
		WebResource resource = getResourceFactory().getApiResource( 
				"/item/app/" + appId + "/count");
		if (viewId != null) {
			resource = resource.queryParam("view_id", viewId.toString());
		}
		return resource.get( ItemCount.class );
	}
	
}
