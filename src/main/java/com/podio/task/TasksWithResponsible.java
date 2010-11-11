package com.podio.task;

import java.util.List;

import com.podio.user.UserMini;

public class TasksWithResponsible {

	private UserMini responsible;

	private List<Task> tasks;

	public UserMini getResponsible() {
		return responsible;
	}

	public void setResponsible(UserMini responsible) {
		this.responsible = responsible;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
}
