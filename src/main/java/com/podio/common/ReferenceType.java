package com.podio.common;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum ReferenceType {

	ALERT, APP, APP_FIELD, APP_REVISION, BULLETIN, COMMENT, CONVERSATION, 
	MESSAGE, FILE, ITEM, ITEM_REVISION, ITEM_VALUE, NOTIFICATION, ORG, PROFILE, 
	RATING, SPACE, SPACE_MEMBER, STATUS, TASK, USER, WIDGET, QUESTION, QUESTION_ANSWER, 
	ACTION, MEETING, GRANT, TASK_ACTION, ITEM_PARTICIPATION, VOTE;

	@Override
	@JsonValue
	public String toString() {
		return name().toLowerCase();
	}

	@JsonCreator
	public static ReferenceType getByName(String value) {
		return valueOf(value.toUpperCase());
	}
}
