package com.podio.task;

public class TaskTotals {

	/**
	 * The task totals where the active user is responsible
	 */
	private TaskTotal responsible;

	/**
	 * The tasks that the active user have created and delegated to others
	 */
	private TaskTotal delegated;

	public TaskTotal getResponsible() {
		return responsible;
	}

	public void setResponsible(TaskTotal responsible) {
		this.responsible = responsible;
	}

	public TaskTotal getDelegated() {
		return delegated;
	}

	public void setDelegated(TaskTotal delegated) {
		this.delegated = delegated;
	}
}
