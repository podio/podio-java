package com.podio.app;

import java.util.List;

public class ApplicationConfiguration extends ApplicationConfigurationBase {

	private static final long serialVersionUID = 1L;
	
	/**
	 * A comma separated list of the tasks that will automatically be created
	 * when a new item is added
	 */
	private List<ApplicationTask> tasks;

	public ApplicationConfiguration() {
		super();
	}

	public ApplicationConfiguration(String name, String itemName,
			String description, String usage, String externalId, String icon,
			boolean allowEdit, ApplicationViewType defaultView,
			boolean allowAttachments, boolean allowComments, boolean fivestar,
			String fivestarLabel, boolean approved, boolean thumbs,
			String thumbsLabel, boolean rsvp, String rsvpLabel, boolean yesno,
			String yesnoLabel, List<ApplicationTask> tasks) {
		super(name, itemName, description, usage, externalId, icon, allowEdit,
				defaultView, allowAttachments, allowComments, fivestar,
				fivestarLabel, approved, thumbs, thumbsLabel, rsvp, rsvpLabel,
				yesno, yesnoLabel);
		this.tasks = tasks;
	}

	public List<ApplicationTask> getTasks() {
		return tasks;
	}

	public void setTasks(List<ApplicationTask> tasks) {
		this.tasks = tasks;
	}
}
