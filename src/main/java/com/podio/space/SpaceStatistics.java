package com.podio.space;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

public class SpaceStatistics {

	/**
	 * When the space was created
	 */
	private DateTime createdOn;

	/**
	 * The number of active members
	 */
	private int members;

	/**
	 * Number of comments
	 */
	private int comments;

	/**
	 * Number of active item
	 */
	private int items;

	/**
	 * Number of active statuses
	 */
	private int statuses;

	/**
	 * Number of active apps
	 */
	private int apps;

	public DateTime getCreatedOn() {
		return createdOn;
	}

	@JsonProperty("created_on")
	public void setCreatedOn(DateTime createdOn) {
		this.createdOn = createdOn;
	}

	public int getMembers() {
		return members;
	}

	public void setMembers(int members) {
		this.members = members;
	}

	public int getComments() {
		return comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}

	public int getItems() {
		return items;
	}

	public void setItems(int items) {
		this.items = items;
	}

	public int getStatuses() {
		return statuses;
	}

	public void setStatuses(int statuses) {
		this.statuses = statuses;
	}

	public int getApps() {
		return apps;
	}

	public void setApps(int apps) {
		this.apps = apps;
	}

}
