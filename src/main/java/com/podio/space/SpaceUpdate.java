package com.podio.space;

import org.codehaus.jackson.annotate.JsonProperty;

public class SpaceUpdate {

	/**
	 * The new name of the space
	 */
	private String name;

	/**
	 * <code>true</code> if new apps should be announced with a status update,
	 * <code>false</code> otherwise
	 */
	private boolean postOnNewApp;

	/**
	 * <code>true</code> if new members should be announced with a status
	 * update, <code>false</code> otherwise
	 */
	private boolean postOnNewMember;

	public SpaceUpdate(String name, boolean postOnNewApp,
			boolean postOnNewMember) {
		super();
		this.name = name;
		this.postOnNewApp = postOnNewApp;
		this.postOnNewMember = postOnNewMember;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("post_on_new_app")
	public boolean isPostOnNewApp() {
		return postOnNewApp;
	}

	public void setPostOnNewApp(boolean postOnNewApp) {
		this.postOnNewApp = postOnNewApp;
	}

	@JsonProperty("post_on_new_member")
	public boolean isPostOnNewMember() {
		return postOnNewMember;
	}

	public void setPostOnNewMember(boolean postOnNewMember) {
		this.postOnNewMember = postOnNewMember;
	}
}
