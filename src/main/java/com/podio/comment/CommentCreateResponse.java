package com.podio.comment;

import org.codehaus.jackson.annotate.JsonProperty;

public class CommentCreateResponse {

	private int id;

	public int getId() {
		return id;
	}

	@JsonProperty("comment_id")
	public void setId(int id) {
		this.id = id;
	}
}
