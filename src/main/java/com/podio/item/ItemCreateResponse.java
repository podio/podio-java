package com.podio.item;

import org.codehaus.jackson.annotate.JsonProperty;

public class ItemCreateResponse {

	private int id;

	public int getId() {
		return id;
	}

	@JsonProperty("item_id")
	public void setId(int id) {
		this.id = id;
	}
}
