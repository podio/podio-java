package com.podio.app;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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

	@XmlElement(name = "space_id")
	public int getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(int spaceId) {
		this.spaceId = spaceId;
	}

	@XmlElement(name = "notify")
	public boolean isNotify() {
		return notify;
	}

	public void setNotify(boolean notify) {
		this.notify = notify;
	}

	@XmlElement(name = "subscribe")
	public boolean isSubscribe() {
		return subscribe;
	}

	public void setSubscribe(boolean subscribe) {
		this.subscribe = subscribe;
	}

	@XmlElement(name = "fields")
	public List<ApplicationFieldCreate> getFields() {
		return fields;
	}

	public void setFields(List<ApplicationFieldCreate> fields) {
		this.fields = fields;
	}
}
