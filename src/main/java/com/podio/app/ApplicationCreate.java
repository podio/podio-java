package com.podio.app;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ApplicationCreate extends ApplicationBase {

	/**
	 * The id of the space on which the app is placed
	 */
	private int spaceId;

	/**
	 * True if at the space members should be notified about this new app, false
	 * otherwise
	 */
	private boolean notify;

	/**
	 * True if the space members should be subscribed to this new app, false
	 * otherwise,
	 */
	private boolean subscribe;

	private List<ApplicationFieldCreate> fields;

	public ApplicationCreate() {
		super();
	}

	public ApplicationCreate(int spaceId, boolean notify, boolean subscribe,
			ApplicationConfiguration configuration,
			List<ApplicationFieldCreate> fields) {
		super(configuration);
		this.spaceId = spaceId;
		this.notify = notify;
		this.subscribe = subscribe;
		this.fields = fields;
	}

	@JsonProperty("space_id")
	public int getSpaceId() {
		return spaceId;
	}

	@JsonProperty("space_id")
	public void setSpaceId(int spaceId) {
		this.spaceId = spaceId;
	}

	public boolean isNotify() {
		return notify;
	}

	public void setNotify(boolean notify) {
		this.notify = notify;
	}

	public boolean isSubscribe() {
		return subscribe;
	}

	public void setSubscribe(boolean subscribe) {
		this.subscribe = subscribe;
	}

	public List<ApplicationFieldCreate> getFields() {
		return fields;
	}

	public void setFields(List<ApplicationFieldCreate> fields) {
		this.fields = fields;
	}
}
