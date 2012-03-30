package com.podio.notification;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum NotificationType {

	/**
	 * The user was alerted as part of an action
	 */
	ALERT,

	/**
	 * A comment was added to an object
	 */
	COMMENT,

	/**
	 * A file was attached to an object
	 */
	FILE,

	/**
	 * The user was added as a reference on an item
	 */
	MEMBER_REFERENCE_ADD,

	/**
	 * The user was removed as a reference on an item
	 */
	MEMBER_REFERENCE_REMOVE,

	/**
	 * A rating was added to an object
	 */
	RATING,

	/**
	 * The user was invited to join a space
	 */
	SPACE_INVITE,

	/**
	 * The user accepted an invitation to join the space
	 */
	SPACE_ACCEPT,

	/**
	 * The user declined an invitation to join the space
	 */
	SPACE_DECLINE,

	/**
	 * The admin ended the users space membership
	 */
	MEMBER_ENDED_USER,

	/**
	 * The user left the space
	 */
	MEMBER_ENDED_ADMIN,

	/**
	 * The role of the user was changed on a space
	 */
	ROLE_CHANGE,

	/**
	 * An object was created
	 */
	CREATION,

	/**
	 * An object was updated
	 */
	UPDATE,

	/**
	 * An object was deleted
	 */
	DELETE,

	/**
	 * A message was received from a conversation
	 */
	MESSAGE,

	/**
	 * A news item was received from Hoist
	 */
	BULLETIN,

	/**
	 * An item was created on an app with RSVP enabled
	 */
	RSVP,

	/**
	 * A question was answered
	 */
	ANSWER,

	/**
	 * A reminder
	 */
	REMINDER,

	/**
	 * The batch is processing
	 */
	BATCH_PROCESS,

	/**
	 * The batch was completed
	 */
	BATCH_COMPLETE;

	@Override
	@JsonValue
	public String toString() {
		return name().toLowerCase();
	}

	@JsonCreator
	public static NotificationType getByName(String value) {
		return valueOf(value.toUpperCase());
	}
}
