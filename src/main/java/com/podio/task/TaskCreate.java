package com.podio.task;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.LocalDate;

public class TaskCreate {

	/**
	 * The text of the task
	 */
	private String text;

	/**
	 * The description of the task
	 */
	private String description;

	/**
	 * True if the task should be private, false otherwise
	 */
	private boolean priv;

	/**
	 * The due date of the task, if any
	 */
	private LocalDate dueDate;

	/**
	 * The user responsible for the task, no value will make the active user
	 * responsible
	 */
	private int responsible;

	public TaskCreate(String text, String description, boolean priv,
			LocalDate dueDate, int responsible) {
		super();
		this.text = text;
		this.description = description;
		this.priv = priv;
		this.dueDate = dueDate;
		this.responsible = responsible;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPrivate() {
		return priv;
	}

	public void setPrivate(boolean priv) {
		this.priv = priv;
	}

	@JsonProperty("due_date")
	public LocalDate getDueDate() {
		return dueDate;
	}

	@JsonProperty("due_date")
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public int getResponsible() {
		return responsible;
	}

	public void setResponsible(int responsible) {
		this.responsible = responsible;
	}
}
