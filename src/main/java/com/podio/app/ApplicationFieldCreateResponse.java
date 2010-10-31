package com.podio.app;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ApplicationFieldCreateResponse {

	/**
	 * The id of the created field
	 */
	private int id;

	@XmlElement(name = "field_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
