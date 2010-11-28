package com.podio.app;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonAutoDetect()
public class ApplicationMini extends ApplicationBase {

	/**
	 * The id of the app
	 */
	private int id;

	/**
	 * The id of the space on which the app is placed
	 */
	private int spaceId;

	/**
	 * True if there is a date field on the app, false otherwise
	 */
	private boolean dateField;

	@JsonProperty("app_id")
	public int getId() {
		return id;
	}

	@JsonProperty("app_id")
	public void setId(int id) {
		this.id = id;
	}

	@JsonProperty("space_id")
	public int getSpaceId() {
		return spaceId;
	}

	@JsonProperty("space_id")
	public void setSpaceId(int spaceId) {
		this.spaceId = spaceId;
	}

	public boolean isDateField() {
		return dateField;
	}

	@JsonProperty("date_field")
	public void setDateField(boolean dateField) {
		this.dateField = dateField;
	}
}
