package com.podio.task;

import javax.ws.rs.core.MediaType;

import com.podio.BaseAPI;

public class TaskAPI {

	private final BaseAPI baseAPI;

	public TaskAPI(BaseAPI baseAPI) {
		this.baseAPI = baseAPI;
	}

	/**
	 * Assigns the task to another user. This makes the user responsible for the
	 * task and its completion.
	 */
	public void assignTask(int taskId, int responsible) {
		baseAPI.getResource("/task/" + taskId + "/assign")
				.entity(new AssignValue(responsible),
						MediaType.APPLICATION_JSON_TYPE).post();
	}

	public void completeTask(int taskId) {
		baseAPI.getResource("/task/" + taskId + "/complete")
				.type(MediaType.APPLICATION_JSON_TYPE).post();
	}

	public void incompleteTask(int taskId) {
		baseAPI.getResource("/task/" + taskId + "/incomplete")
				.entity(null, MediaType.APPLICATION_JSON_TYPE).post();
	}
}
