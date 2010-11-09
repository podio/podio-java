package com.podio.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnySetter;

public class TasksByDue {

	private Map<TaskDueStatus, List<Task>> map = new HashMap<TaskDueStatus, List<Task>>();

	@Override
	public String toString() {
		return "TasksByDue [map=" + map + "]";
	}

	public List<Task> getByDueStatus(TaskDueStatus status) {
		return map.get(status);
	}

	@JsonAnySetter
	public void setByDueStatus(String status, List<Task> tasks) {
		map.put(TaskDueStatus.getByName(status), tasks);
	}
}
