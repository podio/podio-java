package com.podio.task;

import java.util.List;

import com.podio.user.UserProfileMini;

public class TasksWithResponsible {

	private UserProfileMini responsible;

	private List<Task> tasks;

	public UserProfileMini getResponsible() {
		return responsible;
	}

	public void setResponsible(UserProfileMini responsible) {
		this.responsible = responsible;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
}
