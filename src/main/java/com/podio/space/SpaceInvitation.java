package com.podio.space;

import java.util.List;

import com.podio.common.Role;

public class SpaceInvitation {

	/**
	 * The role of the new users
	 */
	private Role role;

	/**
	 * The subject to put in the invitation mail to the users
	 */
	private String subject;

	/**
	 * The personalized message to put in the invitation
	 */
	private String message;

	/**
	 * <code>true</code> if the invitation should be resend every week,
	 * <code>false</code> otherwise
	 */
	private boolean resend;

	/**
	 * <code>true</code> if the inviter should be notified when the user accepts
	 * or declines the invitation, <code>false</code> otherwise
	 */
	private boolean notify;

	/**
	 * The list of user ids of existing Podio users
	 */
	private List<Integer> users;

	/**
	 * The list of mail addresses for new or existing Podio users
	 */
	private List<String> mails;

	public SpaceInvitation(Role role, String subject, String message,
			boolean resend, boolean notify, List<Integer> users,
			List<String> mails) {
		super();
		this.role = role;
		this.subject = subject;
		this.message = message;
		this.resend = resend;
		this.notify = notify;
		this.users = users;
		this.mails = mails;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isResend() {
		return resend;
	}

	public void setResend(boolean resend) {
		this.resend = resend;
	}

	public boolean isNotify() {
		return notify;
	}

	public void setNotify(boolean notify) {
		this.notify = notify;
	}

	public List<Integer> getUsers() {
		return users;
	}

	public void setUsers(List<Integer> users) {
		this.users = users;
	}

	public List<String> getMails() {
		return mails;
	}

	public void setMails(List<String> mails) {
		this.mails = mails;
	}
}
