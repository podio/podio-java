package com.podio.app;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ApplicationFieldCreate {

	/**
	 * The type of the field (see area for more information)
	 */
	private ApplicationFieldType type;

	/**
	 * The configuration of the field
	 */
	private ApplicationFieldConfiguration configuration;

	public ApplicationFieldCreate() {
		super();
	}

	public ApplicationFieldCreate(ApplicationFieldType type,
			ApplicationFieldConfiguration configuration) {
		super();
		this.type = type;
		this.configuration = configuration;
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
