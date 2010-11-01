package com.podio.comment;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.podio.file.File;
import com.podio.user.UserMini;

@XmlRootElement
public class Comment {

	/**
	 * The id of the comment. Can be used to update and delete the comment
	 */
	private int id;

	/**
	 * The actual comment
	 */
	private String value;

	/**
	 * The user who created the comment
	 */
	private UserMini user;

	/**
	 * The date and time the comment was created
	 */
	private Date createdOn;

	/**
	 * The alerts on the comment
	 */
	private List<UserMini> alerts;

	/**
	 * The files on the comment
	 */
	private List<File> files;

	@XmlElement(name = "comment_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement(name = "value")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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

	@XmlElement(name = "alerts")
	public List<UserMini> getAlerts() {
		return alerts;
	}

	public void setAlerts(List<UserMini> alerts) {
		this.alerts = alerts;
	}

	@XmlElement(name = "files")
	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}
}
