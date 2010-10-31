package com.podio.space;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.podio.org.Organization;

@XmlRootElement
public class SpaceWithOrganization extends Space {

	private Organization organization;

	@XmlElement(name = "org")
	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
}
