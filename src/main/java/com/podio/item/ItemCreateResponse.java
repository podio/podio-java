package com.podio.item;

import org.codehaus.jackson.annotate.JsonProperty;

public class ItemCreateResponse {

	private int itemId;

	@JsonProperty("item_id")
	public int getItemId() {
		return itemId;
	}

	@JsonProperty("item_id")
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
}
