package com.podio.space;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.org.OrganizationWithSpaces;

public class SpaceWithOrganization extends Space {

	private OrganizationWithSpaces organization;

	@JsonProperty("org")
	public OrganizationWithSpaces getOrganization() {
		return organization;
	}

	@JsonProperty("org")
	public void setOrganization(OrganizationWithSpaces organization) {
		this.organization = organization;
	}
}
