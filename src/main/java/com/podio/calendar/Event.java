package com.podio.calendar;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

import com.podio.app.Application;
import com.podio.common.ReferenceType;

public class Event {

	/**
	 * The UID of the event
	 */
	private String uid;

	/**
	 * The type of the entry, either "task" or "item"
	 */
	private ReferenceType refType;

	/**
	 * The id of the entry
	 */
	private int refId;

	/**
	 * The title of the entry
	 */
	private String title;

	/**
	 * The description of the entry
	 */
	private String description;

	/**
	 * The location of the entry
	 */
	private String location;

	/**
	 * The active users participation status
	 */
	private ParticipationStatus status;
	
	/**
	 * True if the user is marked as busy, false otherwise
	 */
	private boolean busy;
	
	/**
	 * The version of the event, increments on each change
	 */
	private int version;

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
	 * The application the event belongs to
	 */
	private Application application;


	@JsonProperty("uid")
	public String getUID() {
		return uid;
	}

	public void setUID(String uid) {
		this.uid = uid;
	}

	@JsonProperty("ref_type")
	public ReferenceType getRefType() {
		return refType;
	}

	public void setRefType(ReferenceType refType) {
		this.refType = refType;
	}

	@JsonProperty("ref_id")
	public int getRefId() {
		return refId;
	}

	public void setRefId(int refId) {
		this.refId = refId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public ParticipationStatus getStatus() {
		return status;
	}

	public void setStatus(ParticipationStatus status) {
		this.status = status;
	}

	public boolean isBusy() {
		return busy;
	}

	public void setBusy(boolean busy) {
		this.busy = busy;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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
	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}
}
