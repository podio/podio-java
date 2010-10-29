package com.podio.app;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ApplicationField {

	/**
	 * The id of the field
	 */
	private int id;

	/**
	 * The type of the field (see area for more information)
	 */
	private ApplicationFieldType type;

	/**
	 * The configuration of the field
	 */
	private ApplicationFieldConfiguration configuration;

	@XmlElement(name = "field_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement(name = "type")
	public ApplicationFieldType getType() {
		return type;
	}

	public void setType(ApplicationFieldType type) {
		this.type = type;
	}

	@XmlElement(name = "config")
	public ApplicationFieldConfiguration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(ApplicationFieldConfiguration configuration) {
		this.configuration = configuration;
	}
}
