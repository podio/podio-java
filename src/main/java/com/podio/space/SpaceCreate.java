package com.podio.space;

import org.codehaus.jackson.annotate.JsonProperty;

public class SpaceCreate extends SpaceUpdate {

	private int orgId;

	public SpaceCreate(String name, boolean postOnNewApp,
			boolean postOnNewMember, int orgId) {
		super(name, postOnNewApp, postOnNewMember);
		this.orgId = orgId;
	}

	@JsonProperty("org_id")
	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
}
