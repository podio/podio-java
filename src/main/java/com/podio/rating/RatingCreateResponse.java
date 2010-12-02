package com.podio.rating;

import org.codehaus.jackson.annotate.JsonProperty;

public class RatingCreateResponse {

	private int id;

	public int getId() {
		return id;
	}

	@JsonProperty("rating_id")
	public void setId(int id) {
		this.id = id;
	}
}
