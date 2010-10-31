package com.podio.app;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ApplicationBase {

	/**
	 * The current configuration of the app
	 */
	private ApplicationConfiguration configuration;

	public ApplicationBase() {
		super();
	}

	public ApplicationBase(ApplicationConfiguration configuration) {
		super();
		this.configuration = configuration;
	}

	@XmlElement(name = "config")
	public ApplicationConfiguration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(ApplicationConfiguration configuration) {
		this.configuration = configuration;
	}
}
