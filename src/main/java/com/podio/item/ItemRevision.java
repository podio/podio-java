package com.podio.item;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.podio.user.UserMini;

@XmlRootElement
public class ItemRevision {

	/**
	 * The revision number
	 */
	private int revision;

	/**
	 * The revision of the app at the time this item revision was made
	 */
	private int appRevision;

	/**
	 * The user who made the revision
	 */
	private UserMini user;

	/**
	 * When the revision was created
	 */
	private Date createdOn;

	@XmlElement(name = "revision")
	public int getRevision() {
		return revision;
	}

	public void setRevision(int revision) {
		this.revision = revision;
	}

	@XmlElement(name = "app_revision")
	public int getAppRevision() {
		return appRevision;
	}

	public void setAppRevision(int appRevision) {
		this.appRevision = appRevision;
	}

	@XmlElement(name = "user")
	public UserMini getUser() {
		return user;
	}

	public void setUser(UserMini user) {
		this.user = user;
	}

	@XmlElement(name = "created_on")
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

}
