package com.podio.space;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.org.Organization;

public class SpaceWithOrganization extends Space {

	private Organization organization;

	@JsonProperty("org")
	public Organization getOrganization() {
		return organization;
	}

	@JsonProperty("org")
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
}
