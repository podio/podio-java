package com.podio.calendar;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Calendar {

	private String feedToken;

	private List<Event> events;

	@JsonProperty("feed_token")
	public String getFeedToken() {
		return feedToken;
	}

	@JsonProperty("feed_token")
	public void setFeedToken(String feedToken) {
		this.feedToken = feedToken;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

}
