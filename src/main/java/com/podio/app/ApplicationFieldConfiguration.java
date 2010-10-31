package com.podio.app;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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

	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "label")
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@XmlElement(name = "delta")
	public int getDelta() {
		return delta;
	}

	public void setDelta(int delta) {
		this.delta = delta;
	}

	@XmlElement(name = "settings")
	public ApplicationFieldSettings getSettings() {
		return settings;
	}

	public void setSettings(ApplicationFieldSettings settings) {
		this.settings = settings;
	}

	@XmlElement(name = "required")
	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	@XmlElement(name = "visible")
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
