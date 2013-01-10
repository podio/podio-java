package com.podio.calendar;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

import com.podio.app.ApplicationMini;
import com.podio.common.ReferenceType;

public class Event {

	/**
	 * The type of the entry, either "task" or "item"
	 */
	private ReferenceType type;

	/**
	 * The id of the entry
	 */
	private int id;

	/**
	 * The group of the object, null for tasks and app item name for items
	 */
	private String group;

	/**
	 * The title of the entry
	 */
	private String title;

	/**
	 * The start date
	 */
	private DateTime start;

	/**
	 * The end date, if any
	 */
	private DateTime end;

	/**
	 * The full link to the object
	 */
	private String link;

	/**
	 * The app the event comes from, if any
	 */
	private ApplicationMini application;

	public ReferenceType getType() {
		return type;
	}

	public void setType(ReferenceType type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public DateTime getStart() {
		return start;
	}

	public void setStart(DateTime start) {
		this.start = start;
	}

	public DateTime getEnd() {
		return end;
	}

	public void setEnd(DateTime end) {
		this.end = end;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@JsonProperty("app")
	public ApplicationMini getApplication() {
		return application;
	}

	@JsonProperty("app")
	public void setApplication(ApplicationMini application) {
		this.application = application;
	}
}
