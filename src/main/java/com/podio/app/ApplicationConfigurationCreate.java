package com.podio.app;

import java.util.List;

public class ApplicationConfigurationCreate extends
		ApplicationConfigurationBase {

	private static final long serialVersionUID = 1L;

	/**
	 * A comma separated list of the tasks that will automatically be created
	 * when a new item is added
	 */
	private List<ApplicationTaskCreate> tasks;

	public ApplicationConfigurationCreate() {
		super();
	}

	public ApplicationConfigurationCreate(String name, String itemName,
			String description, String usage, String externalId, String icon,
			boolean allowEdit, ApplicationViewType defaultView,
			boolean allowAttachments, boolean allowComments, boolean fivestar,
			String fivestarLabel, boolean approved, boolean thumbs,
			String thumbsLabel, boolean rsvp, String rsvpLabel, boolean yesno,
			String yesnoLabel, List<ApplicationTaskCreate> tasks) {
		super(name, itemName, description, usage, externalId, icon, allowEdit,
				defaultView, allowAttachments, allowComments, fivestar,
				fivestarLabel, approved, thumbs, thumbsLabel, rsvp, rsvpLabel,
				yesno, yesnoLabel);
		this.tasks = tasks;
	}

	public List<ApplicationTaskCreate> getTasks() {
		return tasks;
	}

	public void setTasks(List<ApplicationTaskCreate> tasks) {
		this.tasks = tasks;
	}

}
