package com.podio.org;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.podio.BaseAPI;
import com.sun.jersey.api.client.GenericType;

public class OrgAPI {

	private final BaseAPI baseAPI;

	public OrgAPI(BaseAPI baseAPI) {
		this.baseAPI = baseAPI;
	}

	public Organization getOrganization(int orgId) {
		return baseAPI.getResource("/org/" + orgId)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(Organization.class);
	}

	public List<Organization> getOrganizations() {
		return baseAPI.getResource("/org/")
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(new GenericType<List<Organization>>() {
				});
	}
}
