package com.podio.task;

import java.util.Collections;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.joda.time.LocalDate;

import com.podio.BaseAPI;
import com.podio.common.Empty;
import com.podio.common.Reference;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;

public class TaskAPI {

	private final BaseAPI baseAPI;

	public TaskAPI(BaseAPI baseAPI) {
		this.baseAPI = baseAPI;
	}

	/**
	 * Returns the task with the given id.
	 */
	public Task getTask(int taskId) {
		return baseAPI.getResource("/task/" + taskId)
				.accept(MediaType.APPLICATION_JSON_TYPE).get(Task.class);
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

	/**
	 * Mark the given task as completed.
	 */
	public void completeTask(int taskId) {
		baseAPI.getResource("/task/" + taskId + "/complete")
				.entity(new Empty(), MediaType.APPLICATION_JSON_TYPE).post();
	}

	/**
	 * Mark the completed task as no longer being completed.
	 */
	public void incompleteTask(int taskId) {
		baseAPI.getResource("/task/" + taskId + "/incomplete")
				.entity(new Empty(), MediaType.APPLICATION_JSON_TYPE).post();
	}

	/**
	 * Indicate that work has started on the given task.
	 */
	public void startTask(int taskId) {
		baseAPI.getResource("/task/" + taskId + "/start")
				.entity(new Empty(), MediaType.APPLICATION_JSON_TYPE).post();
	}

	/**
	 * Indicate that worked has stopped on the given task.
	 */
	public void stopTask(int taskId) {
		baseAPI.getResource("/task/" + taskId + "/stop")
				.entity(new Empty(), MediaType.APPLICATION_JSON_TYPE).post();
	}

	/**
	 * Updates the due date of the task to the given value
	 */
	public void updateDueDate(int taskId, LocalDate dueDate) {
		baseAPI.getResource("/task/" + taskId + "/due_date")
				.entity(new TaskDueDate(dueDate),
						MediaType.APPLICATION_JSON_TYPE).put();
	}

	/**
	 * Update the private flag on the given task.
	 */
	public void updatePrivate(int taskId, boolean priv) {
		baseAPI.getResource("/task/" + taskId + "/private")
				.entity(new TaskPrivate(priv), MediaType.APPLICATION_JSON_TYPE)
				.put();
	}

	/**
	 * Updates the text of the task.
	 */
	public void updateText(int taskId, String text) {
		baseAPI.getResource("/task/" + taskId + "/text")
				.entity(new TaskText(text), MediaType.APPLICATION_JSON_TYPE)
				.put();
	}

	/**
	 * Creates a new task with no reference to other objects.
	 */
	public int createTask(TaskCreate task) {
		TaskCreateResponse response = baseAPI.getResource("/task/")
				.entity(task, MediaType.APPLICATION_JSON_TYPE)
				.post(TaskCreateResponse.class);

		return response.getId();
	}

	/**
	 * Creates a new task with a reference to the given object.
	 */
	public int createTaskWithReference(TaskCreate task, Reference reference) {
		TaskCreateResponse response = baseAPI
				.getResource(
						"/task/" + reference.getType().name().toLowerCase()
								+ "/" + reference.getId() + "/")
				.entity(task, MediaType.APPLICATION_JSON_TYPE)
				.post(TaskCreateResponse.class);

		return response.getId();
	}

	/**
	 * Gets a list of tasks with a reference to the given object. This will
	 * return both active and completed tasks. The reference will not be set on
	 * the individual tasks.
	 */
	public List<Task> getTasksWithReference(Reference reference) {
		return baseAPI
				.getResource(
						"/task/" + reference.getType().name().toLowerCase()
								+ "/" + reference.getId() + "/")
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(new GenericType<List<Task>>() {
				});
	}

	/**
	 * Returns the active tasks of the user. This is the tasks where the user is
	 * responsible.
	 * 
	 * The tasks will be sorted by due date and creation time, and grouped by
	 * their due date status.
	 */
	public TasksByDue getActiveTasks() {
		return baseAPI.getResource("/task/active/")
				.accept(MediaType.APPLICATION_JSON_TYPE).get(TasksByDue.class);
	}

	/**
	 * Returns the tasks that the user has assigned to another user.
	 */
	public TasksByDue getAssignedActiveTasks() {
		return baseAPI.getResource("/task/assigned/active/")
				.accept(MediaType.APPLICATION_JSON_TYPE).get(TasksByDue.class);
	}

	/**
	 * Returns the tasks that the user has assigned to another user.
	 */
	public List<Task> getAssignedCompletedTasks() {
		try {
			return baseAPI.getResource("/task/assigned/completed/")
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.get(new GenericType<List<Task>>() {
					});
		} catch (UniformInterfaceException e) {
			if (e.getResponse().getStatus() == 204) {
				return Collections.<Task> emptyList();
			} else {
				throw e;
			}
		}
	}

	/**
	 * Returns the tasks that is completed and where the active user is
	 * responsible.
	 */
	public List<Task> getCompletedTasks() {
		try {
			return baseAPI.getResource("/task/completed/")
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.get(new GenericType<List<Task>>() {
					});
		} catch (UniformInterfaceException e) {
			if (e.getResponse().getStatus() == 204) {
				return Collections.<Task> emptyList();
			} else {
				throw e;
			}
		}
	}

	/**
	 * Returns the tasks that are started and where the active user is the
	 * responsible.
	 */
	public TasksByDue getStartedTasks() {
		return baseAPI.getResource("/task/started/")
				.accept(MediaType.APPLICATION_JSON_TYPE).get(TasksByDue.class);
	}
}
