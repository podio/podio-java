package com.podio.app;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ApplicationFieldUpdate {

	/**
	 * The id of the field
	 */
	private int id;

	/**
	 * The configuration of the field
	 */
	private ApplicationFieldConfiguration configuration;

	public ApplicationFieldUpdate() {
		super();
	}

	public ApplicationFieldUpdate(int id,
			ApplicationFieldConfiguration configuration) {
		super();
		this.id = id;
		this.configuration = configuration;
	}

	@XmlElement(name = "field_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement(name = "config")
	public ApplicationFieldConfiguration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(ApplicationFieldConfiguration configuration) {
		this.configuration = configuration;
	}
}
