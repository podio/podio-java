package com.podio.app;

import java.io.Serializable;

public class ApplicationFieldConfiguration implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * The label of the field, which is what the users will see
	 */
	private String label;

	/**
	 * The description of the field, which is a help to users inserting/updating
	 * an item
	 */
	private String description;

	/**
	 * An integer indicating the order of the field compared to other fields
	 */
	private int delta;

	/**
	 * The settings of the field which depends on the type of the field (see
	 * area for more information)
	 */
	private ApplicationFieldSettings settings;

	/**
	 * True if the field is required when creating and editing items, false
	 * otherwise
	 */
	private boolean required;

	public ApplicationFieldConfiguration() {
		super();
	}

	public ApplicationFieldConfiguration(String label, String description,
			int delta, ApplicationFieldSettings settings, boolean required) {
		super();
		this.label = label;
		this.description = description;
		this.delta = delta;
		this.settings = settings;
		this.required = required;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDelta() {
		return delta;
	}

	public void setDelta(int delta) {
		this.delta = delta;
	}

	public ApplicationFieldSettings getSettings() {
		return settings;
	}

	public void setSettings(ApplicationFieldSettings settings) {
		this.settings = settings;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}
}
