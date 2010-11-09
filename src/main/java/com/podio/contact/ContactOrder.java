package com.podio.contact;

public enum ContactOrder {

	/**
	 * How often the active user assigns tasks to the contact
	 */
	TASK,

	/**
	 * How often the active user receives messages from the contact
	 */
	MESSAGE_IN,

	/**
	 * How often the active user sends messages to the contact
	 */
	MESSAGE_OUT,

	/**
	 * How often the active user sets the contact as the reference on an item
	 * field.
	 */
	REFERENCE,

	/**
	 * How often the active user have alerted the contact in a status or
	 * comment.
	 */
	ALERT;
}
