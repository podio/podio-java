package com.podio.org;

public class OrganizationCreate {

	/**
	 * The name of the new organization
	 */
	private String name;

	/**
	 * The file id of the logo of the organization
	 */
	private Integer logo;

	public OrganizationCreate(String name, Integer logo) {
		super();
		this.name = name;
		this.logo = logo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLogo() {
		return logo;
	}

	public void setLogo(Integer logo) {
		this.logo = logo;
	}
}
