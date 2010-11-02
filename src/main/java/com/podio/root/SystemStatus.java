package com.podio.root;


public class SystemStatus {

	private String version;

	private boolean database;

	private boolean messaging;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public boolean isDatabase() {
		return database;
	}

	public void setDatabase(boolean database) {
		this.database = database;
	}

	public boolean isMessaging() {
		return messaging;
	}

	public void setMessaging(boolean messaging) {
		this.messaging = messaging;
	}

}
