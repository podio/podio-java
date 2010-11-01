package com.podio.item;

import javax.ws.rs.core.MediaType;

import com.podio.BaseAPI;

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
}
