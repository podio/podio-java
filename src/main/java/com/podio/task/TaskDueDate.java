package com.podio.task;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.LocalDate;

public class TaskDueDate {

	private final LocalDate dueDate;

	public TaskDueDate(LocalDate dueDate) {
		super();
		this.dueDate = dueDate;
	}

	@JsonProperty("due_date")
	public LocalDate getDueDate() {
		return dueDate;
	}
}
