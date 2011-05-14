package com.podio.hook;

import org.codehaus.jackson.annotate.JsonProperty;

public class HookCreateResponse {

	/**
	 * The id of the hook created
	 */
	private int id;

	public int getId() {
		return id;
	}

	@JsonProperty("hook_id")
	public void setId(int id) {
		this.id = id;
	}
}
