package com.podio.item;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.podio.BaseAPI;
import com.sun.jersey.api.client.GenericType;

public class ItemAPI {

	private final BaseAPI baseAPI;

	public ItemAPI(BaseAPI baseAPI) {
		this.baseAPI = baseAPI;
	}

	public ItemCreateResponse addItem(int appId, ItemCreate create) {
		return baseAPI.getResource("/item/app/" + appId + "/")
				.entity(create, MediaType.APPLICATION_JSON_TYPE)
				.post(ItemCreateResponse.class);
	}

	public Item getItem(int itemId) {
		return baseAPI.getResource("/item/" + itemId)
				.accept(MediaType.APPLICATION_JSON_TYPE).get(Item.class);
	}

	public List<ItemReference> getItemReference(int itemId) {
		return baseAPI.getResource("/item/" + itemId + "/reference/")
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(new GenericType<List<ItemReference>>() {
				});
	}
}
