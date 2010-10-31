package com.podio.app;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ApplicationInstall {

	private int spaceId;

	public ApplicationInstall() {
		super();
	}

	public ApplicationInstall(int spaceId) {
		super();
		this.spaceId = spaceId;
	}

	@XmlElement(name = "space_id")
	public int getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(int spaceId) {
		this.spaceId = spaceId;
	}

}
