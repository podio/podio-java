package com.podio.contact;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.org.OrganizationMini;

public class ContactTotal {

	private OrganizationMini organization;

	private int contacts;

	@JsonProperty("org")
	public OrganizationMini getOrganization() {
		return organization;
	}

	@JsonProperty("org")
	public void setOrganization(OrganizationMini organization) {
		this.organization = organization;
	}

	public int getContacts() {
		return contacts;
	}

	public void setContacts(int contacts) {
		this.contacts = contacts;
	}
}
