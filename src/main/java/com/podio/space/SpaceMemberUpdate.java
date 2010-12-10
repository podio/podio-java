package com.podio.space;

import com.podio.common.Role;

public class SpaceMemberUpdate {

	private Role role;

	public SpaceMemberUpdate(Role role) {
		super();
		this.role = role;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
