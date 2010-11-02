package com.podio.app;


public class ApplicationFieldConfiguration {

	/**
	 * The name of the field (might be removed in a future version)
	 */
	private String name;

	/**
	 * The label of the field, which is what the users will see
	 */
	private String label;

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

	/**
	 * True if the field is visible, false otherwise (might be removed in a
	 * future version)
	 */
	private boolean visible;

	public ApplicationFieldConfiguration() {
		super();
	}

	public ApplicationFieldConfiguration(String name, String label, int delta,
			ApplicationFieldSettings settings, boolean required, boolean visible) {
		super();
		this.name = name;
		this.label = label;
		this.delta = delta;
		this.settings = settings;
		this.required = required;
		this.visible = visible;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
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

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
