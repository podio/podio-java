package com.podio.contact;

import java.util.List;

public class UserContactTotal {

	private List<OrganizationContactTotal> organizations;

	private int count;

	public List<OrganizationContactTotal> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(List<OrganizationContactTotal> organizations) {
		this.organizations = organizations;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
