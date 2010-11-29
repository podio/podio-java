package com.podio.task;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.joda.time.LocalDate;

import com.podio.BaseAPI;
import com.podio.common.Empty;
import com.podio.common.Reference;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

/**
 * Tasks are used to track what work has to be done. Tasks have the following
 * properties:
 * 
 * <ul>
 * <li>Tasks can be stand-alone or can be attached to other objects.
 * <li>Tasks can be delegated to other users of Hoist.
 * <li>Tasks can be private or public. When private, only the creator, the
 * assignee and assignor can see the task.
 * <li>Tasks can have a due date, which is the target date for completion. When
 * tasks miss their due date, they become over-due.
 * <li>Tasks can be started on or not started on. This is used to indicate to
 * other users if the task is in progress.
 * </ul>
 * 
 * A task can be in one of the following states:
 * 
 * <ul>
 * <li>active: The task is active and not yet completed
 * <li>completed: The task is completed
 * </ul>
 * 
 * The following actions can be performed on a task:
 * <ul>
 * <li>assign: Reassign the task to another user to make that user responsible
 * for the task
 * <li>update due date: Update the due date of the task
 * <li>update text: Update the text of the task
 * <li>update private: Make the task private or public start: Indicate that
 * worked have started on the task stop: Indicate that work have been stopped
 * complete: Mark the task as completed incomplete: Mark the task as being
 * incomplete
 * 
 * @author admin
 * 
 */
public class TaskAPI {

	private final BaseAPI baseAPI;

	public TaskAPI(BaseAPI baseAPI) {
		this.baseAPI = baseAPI;
	}

	/**
	 * Returns the task with the given id.
	 */
	public Task getTask(int taskId) {
		return baseAPI.getApiResource("/task/" + taskId)
				.accept(MediaType.APPLICATION_JSON_TYPE).get(Task.class);
	}

	/**
	 * Assigns the task to another user. This makes the user responsible for the
	 * task and its completion.
	 */
	public void assignTask(int taskId, int responsible) {
		baseAPI.getApiResource("/task/" + taskId + "/assign")
				.entity(new AssignValue(responsible),
						MediaType.APPLICATION_JSON_TYPE).post();
	}

	/**
	 * Mark the given task as completed.
	 */
	public void completeTask(int taskId) {
		baseAPI.getApiResource("/task/" + taskId + "/complete")
				.entity(new Empty(), MediaType.APPLICATION_JSON_TYPE).post();
	}

	/**
	 * Mark the completed task as no longer being completed.
	 */
	public void incompleteTask(int taskId) {
		baseAPI.getApiResource("/task/" + taskId + "/incomplete")
				.entity(new Empty(), MediaType.APPLICATION_JSON_TYPE).post();
	}

	/**
	 * Indicate that work has started on the given task.
	 */
	public void startTask(int taskId) {
		baseAPI.getApiResource("/task/" + taskId + "/start")
				.entity(new Empty(), MediaType.APPLICATION_JSON_TYPE).post();
	}

	/**
	 * Indicate that worked has stopped on the given task.
	 */
	public void stopTask(int taskId) {
		baseAPI.getApiResource("/task/" + taskId + "/stop")
				.entity(new Empty(), MediaType.APPLICATION_JSON_TYPE).post();
	}

	/**
	 * Updates the due date of the task to the given value
	 */
	public void updateDueDate(int taskId, LocalDate dueDate) {
		baseAPI.getApiResource("/task/" + taskId + "/due_date")
				.entity(new TaskDueDate(dueDate),
						MediaType.APPLICATION_JSON_TYPE).put();
	}

	/**
	 * Update the private flag on the given task.
	 */
	public void updatePrivate(int taskId, boolean priv) {
		baseAPI.getApiResource("/task/" + taskId + "/private")
				.entity(new TaskPrivate(priv), MediaType.APPLICATION_JSON_TYPE)
				.put();
	}

	/**
	 * Updates the text of the task.
	 */
	public void updateText(int taskId, String text) {
		baseAPI.getApiResource("/task/" + taskId + "/text")
				.entity(new TaskText(text), MediaType.APPLICATION_JSON_TYPE)
				.put();
	}

	/**
	 * Creates a new task with no reference to other objects.
	 */
	public int createTask(TaskCreate task) {
		TaskCreateResponse response = baseAPI.getApiResource("/task/")
				.entity(task, MediaType.APPLICATION_JSON_TYPE)
				.post(TaskCreateResponse.class);

		return response.getId();
	}

	/**
	 * Creates a new task with a reference to the given object.
	 */
	public int createTaskWithReference(TaskCreate task, Reference reference) {
		TaskCreateResponse response = baseAPI
				.getApiResource(
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
				.getApiResource(
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
		return baseAPI.getApiResource("/task/active/")
				.accept(MediaType.APPLICATION_JSON_TYPE).get(TasksByDue.class);
	}

	/**
	 * Returns the tasks that the user has assigned to another user.
	 */
	public TasksByDue getAssignedActiveTasks() {
		return baseAPI.getApiResource("/task/assigned/active/")
				.accept(MediaType.APPLICATION_JSON_TYPE).get(TasksByDue.class);
	}

	/**
	 * Returns the tasks that the user has assigned to another user.
	 */
	public List<Task> getAssignedCompletedTasks() {
		return baseAPI.getApiResource("/task/assigned/completed/")
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(new GenericType<List<Task>>() {
				});
	}

	/**
	 * Returns the tasks that is completed and where the active user is
	 * responsible.
	 */
	public List<Task> getCompletedTasks() {
		return baseAPI.getApiResource("/task/completed/")
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(new GenericType<List<Task>>() {
				});
	}

	/**
	 * Returns the tasks that are started and where the active user is the
	 * responsible.
	 */
	public TasksByDue getStartedTasks() {
		return baseAPI.getApiResource("/task/started/")
				.accept(MediaType.APPLICATION_JSON_TYPE).get(TasksByDue.class);
	}

	/**
	 * Returns all the tasks that are related to the space. It includes tasks
	 * with a direct reference to the space, and tasks with an indirect
	 * reference to the space (like items and status updates).
	 */
	public TasksByDue getTasksInSpaceByDue(int spaceId) {
		return baseAPI.getApiResource("/task/in_space/" + spaceId + "/")
				.queryParam("sort_by", "due_date")
				.accept(MediaType.APPLICATION_JSON_TYPE).get(TasksByDue.class);
	}

	/**
	 * Returns all the tasks that are related to the space. It includes tasks
	 * with a direct reference to the space, and tasks with an indirect
	 * reference to the space (like items and status updates).
	 */
	public List<TasksWithResponsible> getTasksInSpaceByResponsible(int spaceId) {
		return baseAPI.getApiResource("/task/in_space/" + spaceId + "/")
				.queryParam("sort_by", "responsible")
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(new GenericType<List<TasksWithResponsible>>() {
				});
	}

	/**
	 * Returns the total task count for the active user.
	 */
	public TaskTotals getTaskTotals() {
		return getTaskTotals(null);
	}

	/**
	 * Returns the total task count for the active user.
	 */
	public TaskTotals getTaskTotals(Integer spaceId) {
		WebResource resource = baseAPI.getApiResource("/task/total");
		if (spaceId != null) {
			resource = resource.queryParam("space_id", spaceId.toString());
		}

		return resource.accept(MediaType.APPLICATION_JSON_TYPE).get(
				TaskTotals.class);
	}
}
