package com.podio.task;

import java.util.List;

import com.podio.contact.ProfileMini;

public class TasksWithResponsible {

	private ProfileMini responsible;

	private List<Task> tasks;

	public ProfileMini getResponsible() {
		return responsible;
	}

	public void setResponsible(ProfileMini responsible) {
		this.responsible = responsible;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
}
