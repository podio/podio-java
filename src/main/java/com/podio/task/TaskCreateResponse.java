package com.podio.task;

import org.codehaus.jackson.annotate.JsonProperty;

public class TaskCreateResponse {

	private int id;

	@JsonProperty("task_id")
	public int getId() {
		return id;
	}

	@JsonProperty("task_id")
	public void setId(int id) {
		this.id = id;
	}
}
