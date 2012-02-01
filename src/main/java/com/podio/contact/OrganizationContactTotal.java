package com.podio.contact;

import java.util.List;

import com.podio.org.Organization;

public class OrganizationContactTotal {

	private Organization org;

	private int count;

	private List<SpaceContactTotal> spaces;

	public Organization getOrg() {
		return org;
	}

	public void setOrg(Organization org) {
		this.org = org;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<SpaceContactTotal> getSpaces() {
		return spaces;
	}

	public void setSpaces(List<SpaceContactTotal> spaces) {
		this.spaces = spaces;
	}
}
