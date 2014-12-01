/**
 * Podio Java client library
 */
package com.podio.space;

import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.common.Role;

/**
 * To match the format of the JSON data sent using the 'add member to space' API call
 * 
 * @author apitman
 */
public class SpaceMemberAdd {
	
	/**
	 * The role of the new users
	 */
	private Role role;
	
	/**
	 * The personalized message to put in the invitation
	 */
	private String message;
	
	/**
	 * The list of users ids to invite
	 */
	private List<Integer> users;
	
	/**
	 * The list of profile ids to invite to the space
	 */
	private List<Integer> profiles;
	
	/**
	 * The list of mail addresses for new or existing Podio users
	 */
	private List<String> mails;
	
	/**
	 * The external contacts to invite
	 */
	private MultivaluedMap<Integer, String> externalContacts;
	
	/**
	 * Optionally specify "item" to indicate invite to a specific item
	 */
	private String contextRefType;
	
	/**
	 * Must be set to the item id if source_key is set
	 */
	private int contextRefId;
	
	/**
	 * A optional custom string indicating where the user was when he/she invited the user(s)
	 */
	private String inviteContext;
	
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
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * @return the users
	 */
	public List<Integer> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<Integer> users) {
		this.users = users;
	}
	
	/**
	 * @return the profiles
	 */
	public List<Integer> getProfiles() {
		return profiles;
	}

	/**
	 * @param profiles the profiles to set
	 */
	public void setProfiles(List<Integer> profiles) {
		this.profiles = profiles;
	}

	/**
	 * @return the mails
	 */
	public List<String> getMails() {
		return mails;
	}
	
	/**
	 * @param mails the mails to set
	 */
	public void setMails(List<String> mails) {
		this.mails = mails;
	}
	
	/**
	 * @return the externalContacts
	 */
	@JsonProperty("external_contacts")
	public MultivaluedMap<Integer, String> getExternalContacts() {
		return externalContacts;
	}

	/**
	 * @param externalContacts the externalContacts to set
	 */
	@JsonProperty("external_contacts")
	public void setExternalContacts(MultivaluedMap<Integer, String> externalContacts) {
		this.externalContacts = externalContacts;
	}
	
	/**
	 * @return the contextRefType
	 */
	@JsonProperty("context_ref_type")
	public String getContextRefType() {
		return contextRefType;
	}

	/**
	 * @param contextRefType the contextRefType to set
	 */
	@JsonProperty("context_ref_type")
	public void setContextRefType(String contextRefType) {
		this.contextRefType = contextRefType;
	}

	/**
	 * @return the contextRefId
	 */
	@JsonProperty("context_ref_id")
	public int getContextRefId() {
		return contextRefId;
	}
	
	/**
	 * @param contextRefId the contextRefId to set
	 */
	@JsonProperty("context_ref_id")
	public void setContextRefId(int contextRefId) {
		this.contextRefId = contextRefId;
	}
	
	/**
	 * @return the inviteContext
	 */
	@JsonProperty("invite_context")
	public String getInviteContext() {
		return inviteContext;
	}

	/**
	 * @param inviteContext the inviteContext to set
	 */
	@JsonProperty("invite_context")
	public void setInviteContext(String inviteContext) {
		this.inviteContext = inviteContext;
	}

}
