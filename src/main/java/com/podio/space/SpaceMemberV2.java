/**
 * Podio Java library
 */
package com.podio.space;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.common.Role;
import com.podio.contact.Profile;

/**
 * To match the data returned by the "get space members v2" API call
 * 
 * @author apitman
 */
public class SpaceMemberV2 {
	
	/**
	 * Employee or external user
	 */
	private boolean employee;
	
	/**
	 * The member of the space
	 */
	private Profile profile;
	
	/**
	 * The number of grants given to the user on the space
	 */
	private int grants;
	
	/**
	 * The role that the member has
	 */
	private Role role;
	
	/**
	 * @return the employee
	 */
	public boolean isEmployee() {
		return employee;
	}
	
	/**
	 * @param employee the employee to set
	 */
	@JsonProperty("employee")
	public void setEmployee(boolean employee) {
		this.employee = employee;
	}
	
	/**
	 * @return the profile
	 */
	public Profile getProfile() {
		return profile;
	}
	
	/**
	 * @param profile the profile to set
	 */
	@JsonProperty("profile")
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	/**
	 * @return the grants
	 */
	public int getGrants() {
		return grants;
	}
	
	/**
	 * @param grants the grants to set
	 */
	@JsonProperty("grants")
	public void setGrants(int grants) {
		this.grants = grants;
	}
	
	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}
	
	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}
}
