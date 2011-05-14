package com.podio.stream;

import java.util.HashMap;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.common.CreatedBase;
import com.podio.common.ReferenceType;

public class StreamActivity extends CreatedBase {

	/**
	 * The type of object
	 */
	private ReferenceType type;

	/**
	 * The id of the object
	 */
	private int id;

	/**
	 * The type of activity
	 */
	private StreamActivityType activityType;

	/**
	 * The object itself in short form
	 */
	private HashMap<String, Object> data;

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

	public StreamActivityType getActivityType() {
		return activityType;
	}

	@JsonProperty("activity_type")
	public void setActivityType(StreamActivityType activityType) {
		this.activityType = activityType;
	}

	public HashMap<String, Object> getData() {
		return data;
	}

	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}
}
