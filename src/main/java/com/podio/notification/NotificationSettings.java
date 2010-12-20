package com.podio.notification;

public class NotificationSettings {

	/**
	 * <code>true</code> if digest emails should be sent out, <code>false</code>
	 * otherwise
	 */
	private boolean digest;

	/**
	 * <code>true</code> if direct emails should be sent out, <code>false</code>
	 * otherwise
	 */
	private boolean direct;

	public NotificationSettings() {
		super();
	}

	public NotificationSettings(boolean digest, boolean direct) {
		super();
		this.digest = digest;
		this.direct = direct;
	}

	public boolean isDigest() {
		return digest;
	}

	public void setDigest(boolean digest) {
		this.digest = digest;
	}

	public boolean isDirect() {
		return direct;
	}

	public void setDirect(boolean direct) {
		this.direct = direct;
	}
}
