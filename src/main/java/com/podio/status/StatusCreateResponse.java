package com.podio.status;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StatusCreateResponse {

	private int id;

	@XmlElement(name = "status_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
