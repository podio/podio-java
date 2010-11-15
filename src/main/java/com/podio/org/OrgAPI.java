package com.podio.org;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.podio.BaseAPI;

public class OrgAPI {

	private final BaseAPI baseAPI;

	public OrgAPI(BaseAPI baseAPI) {
		this.baseAPI = baseAPI;
	}

	public Organization getOrganization(int orgId) {
		return baseAPI.getApiResource("/org/" + orgId)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(Organization.class);
	}

	public List<Organization> getOrganizations() {
		return Arrays.asList(baseAPI.getApiResource("/org/")
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(Organization[].class));
	}
}
