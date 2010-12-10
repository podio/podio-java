package com.podio.space;

public class SpaceInvitationUpdate {

	/**
	 * The subject to put in the invitation mail to the users
	 */
	private String subject;

	/**
	 * The personalized message to put in the invitation
	 */
	private String message;

	public SpaceInvitationUpdate(String subject, String message) {
		super();
		this.subject = subject;
		this.message = message;
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
}
