package com.podio.task;

import org.codehaus.jackson.annotate.JsonProperty;

public class TaskTotal {

	/**
	 * The total number of overdue tasks
	 */
	private int overDue;

	/**
	 * The total number tasks due today
	 */
	private int dueToday;

	/**
	 * The total number of tasks on which work has started
	 */
	private int started;

	/**
	 * The total number of active tasks
	 */
	private int total;

	@JsonProperty("over_due")
	public int getOverDue() {
		return overDue;
	}

	@JsonProperty("over_due")
	public void setOverDue(int overDue) {
		this.overDue = overDue;
	}

	@JsonProperty("due_today")
	public int getDueToday() {
		return dueToday;
	}

	@JsonProperty("due_today")
	public void setDueToday(int dueToday) {
		this.dueToday = dueToday;
	}

	public int getStarted() {
		return started;
	}

	public void setStarted(int started) {
		this.started = started;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
