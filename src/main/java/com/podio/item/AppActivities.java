package com.podio.item;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class AppActivities {

	private List<AppActivity> today;

	private List<AppActivity> lastWeek;

	public List<AppActivity> getToday() {
		return today;
	}

	public void setToday(List<AppActivity> today) {
		this.today = today;
	}

	public List<AppActivity> getLastWeek() {
		return lastWeek;
	}

	@JsonProperty("last_week")
	public void setLastWeek(List<AppActivity> lastWeek) {
		this.lastWeek = lastWeek;
	}
}
