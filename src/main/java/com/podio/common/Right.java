package com.podio.common;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum Right {

	VIEW, UPDATE, DELETE, SUBSCRIBE, COMMENT, RATE, SHARE, INSTALL, ADD_APP, 
	ADD_ITEM, ADD_FILE, ADD_TASK, ADD_SPACE, ADD_STATUS, ADD_CONVERSATION, REPLY, 
	ADD_FILTER, ADD_WIDGET, STATISTICS, ADD_CONTACT, ADD_HOOK, ADD_ANSWER, 
	ADD_QUESTION, ADD_MEETING, GRANT, DOWNLOAD;

	@Override
	@JsonValue
	public String toString() {
		return name().toLowerCase();
	}

	@JsonCreator
	public static Right getByName(String value) {
		return valueOf(value.toUpperCase());
	}
}
