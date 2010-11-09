package com.podio.task;

import org.junit.Test;

import com.podio.BaseAPIFactory;

public class TaskAPITest {

	private TaskAPI getAPI() {
		return new TaskAPI(BaseAPIFactory.get());
	}

	@Test
	public void assignTask() {
		getAPI().assignTask(1, 1);
	}

	@Test
	public void completeTask() {
		getAPI().completeTask(1);
	}

	@Test
	public void incompleteTask() {
		getAPI().incompleteTask(4);
	}
}
