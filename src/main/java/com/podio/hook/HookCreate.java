package com.podio.hook;

public class HookCreate {

	/**
	 * The url of endpoint
	 */
	private String url;

	/**
	 * The type of events to listen to
	 */
	private HookType type;

	public HookCreate(String url, HookType type) {
		super();
		this.url = url;
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public HookType getType() {
		return type;
	}

	public void setType(HookType type) {
		this.type = type;
	}
}
