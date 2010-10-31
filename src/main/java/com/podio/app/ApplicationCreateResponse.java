package com.podio.app;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ApplicationCreateResponse {

	/**
	 * The id of the created app
	 */
	private int id;

	@XmlElement(name = "app_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
