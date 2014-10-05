package com.podio.space;

import com.podio.common.Role;

public class SpaceMemberDetails {
	
	private Space space;

	private Role role;
	
	private int grants;

	public Space getSpace() {
		return space;
	}

	public Role getRole() {
		return role;
	}

	public int getGrants() {
		return grants;
	}
}
