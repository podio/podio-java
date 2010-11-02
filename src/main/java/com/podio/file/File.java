package com.podio.file;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.user.UserMini;

public class File {

	/**
	 * The id of the file
	 */
	private int fileId;

	/**
	 * The name of the file
	 */
	private String name;

	/**
	 * The description of the file
	 */
	private String description;

	/**
	 * The type of the file, see the area for allowed types
	 */
	private String mimetype;

	/**
	 * The size of the file in bytes
	 */
	private long size;

	/**
	 * The date and time when the file was uploaded
	 */
	private Date createdOn;

	/**
	 * The user who created the file
	 */
	private UserMini createdBy;

	/**
	 * The file this file replaces, if any
	 */
	private List<File> replaces;

	@JsonProperty("file_id")
	public int getFileId() {
		return fileId;
	}

	@JsonProperty("file_id")
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMimetype() {
		return mimetype;
	}

	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	@JsonProperty("created_on")
	public Date getCreatedOn() {
		return createdOn;
	}

	@JsonProperty("created_on")
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@JsonProperty("created_by")
	public UserMini getCreatedBy() {
		return createdBy;
	}

	@JsonProperty("created_by")
	public void setCreatedBy(UserMini createdBy) {
		this.createdBy = createdBy;
	}

	public List<File> getReplaces() {
		return replaces;
	}

	public void setReplaces(List<File> replaces) {
		this.replaces = replaces;
	}
}
