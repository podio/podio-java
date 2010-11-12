package com.podio.item;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.podio.BaseAPI;
import com.podio.filter.ExternalIdFilterBy;
import com.podio.filter.FilterByValue;
import com.podio.filter.SortBy;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

public class ItemAPI {

	private final BaseAPI baseAPI;

	public ItemAPI(BaseAPI baseAPI) {
		this.baseAPI = baseAPI;
	}

	public ItemCreateResponse addItem(int appId, ItemCreate create,
			boolean silent) {
		return baseAPI.getResource("/item/app/" + appId + "/")
				.queryParam("silent", silent ? "1" : "0")
				.entity(create, MediaType.APPLICATION_JSON_TYPE)
				.post(ItemCreateResponse.class);
	}

	public Item getItem(int itemId) {
		return baseAPI.getResource("/item/" + itemId)
				.accept(MediaType.APPLICATION_JSON_TYPE).get(Item.class);
	}

	public void updateItem(int itemId, ItemUpdate update, boolean silent) {
		baseAPI.getResource("/item/" + itemId)
				.queryParam("silent", silent ? "1" : "0")
				.entity(update, MediaType.APPLICATION_JSON_TYPE).put();
	}

	public void deleteItem(int itemId, boolean silent) {
		baseAPI.getResource("/item/" + itemId)
				.queryParam("silent", silent ? "1" : "0").delete();
	}

	public List<ItemReference> getItemReference(int itemId) {
		return baseAPI.getResource("/item/" + itemId + "/reference/")
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(new GenericType<List<ItemReference>>() {
				});
	}

	public ItemsResponse getItems(int appId, Integer limit, Integer offset,
			SortBy sortBy, Boolean sortDesc, FilterByValue... filters) {
		WebResource resource = baseAPI.getResource("/item/app/" + appId
				+ "/v2/");
		if (limit != null) {
			resource = resource.queryParam("limit", limit.toString());
		}
		if (offset != null) {
			resource = resource.queryParam("offset", offset.toString());
		}
		if (sortBy != null) {
			resource = resource.queryParam("sortBy", sortBy.getKey());
		}
		if (sortDesc != null) {
			resource = resource.queryParam("sortDesc", sortDesc ? "1" : "0");
		}
		for (FilterByValue filter : filters) {
			resource = resource.queryParam(filter.getBy().getKey(), filter
					.getBy().format(filter.getValue()));
		}

		return resource.accept(MediaType.APPLICATION_JSON_TYPE).get(
				ItemsResponse.class);
	}

	public ItemsResponse getItemsByExternalId(int appId, String externalId) {
		return getItems(appId, null, null, null, null,
				new FilterByValue<String>(new ExternalIdFilterBy(), externalId));
	}
}
