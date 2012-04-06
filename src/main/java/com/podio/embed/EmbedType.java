package com.podio.embed;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum EmbedType {

	/**
	 * A direct link to a public image
	 */
	IMAGE("image"),

	/**
	 * A link to a video service provider such as YouTube
	 */
	VIDEO("video"),

	/**
	 * A link to a service provider that can be displayed inline, but is not
	 * video (such as SlideShare)
	 */
	RICH("rich"),

	/**
	 * A link to a plain web page
	 */
	LINK("link"),

	/**
	 * An invalid or inaccessible link
	 */
	UNRESOLVED("unresolved");

	private final String externalName;

	private EmbedType(String externalName) {
		this.externalName = externalName;
	}

	@Override
	@JsonValue
	public String toString() {
		return externalName;
	}

	@JsonCreator
	public static EmbedType getByName(String value) {
		for (EmbedType type : values()) {
			if (type.externalName.equals(value)) {
				return type;
			}
		}

		return null;
	}
}
