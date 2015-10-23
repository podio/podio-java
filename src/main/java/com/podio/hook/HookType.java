package com.podio.hook;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum HookType {

	ITEM_CREATE("item.create"),
	ITEM_UPDATE("item.update"),
	ITEM_DELETE("item.delete"),
	COMMENT_CREATE("comment.create"),
	COMMENT_DELETE("comment.delete"),
	FILE_CHANGE("file.change"),
	APP_UPDATE("app.update"),
	APP_DELETE("app.delete");

	private final String externalName;

	private HookType(String externalName) {
		this.externalName = externalName;
	}

	@Override
	@JsonValue
	public String toString() {
		return externalName;
	}

	@JsonCreator
	public static HookType getByName(String value) {
		for (HookType type : values()) {
			if (type.externalName.equals(value)) {
				return type;
			}
		}

		return null;
	}
}
