package com.podio.status;

import org.codehaus.jackson.annotate.JsonProperty;

public class StatusCreateResponse {

	private int id;

	@JsonProperty("status_id")
	public int getId() {
		return id;
	}

	@JsonProperty("status_id")
	public void setId(int id) {
		this.id = id;
	}
}
