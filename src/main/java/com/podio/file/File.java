package com.podio.file;

import java.util.List;

import javax.activation.MimeType;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.common.CreatedBase;

public class File extends CreatedBase {

	/**
	 * The id of the file
	 */
	private int id;

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
	private MimeType mimetype;

	/**
	 * The context of the file, either an item, task or status
	 */
	private FileReference context;

	/**
	 * The size of the file in bytes
	 */
	private long size;

	/**
	 * The file this file replaces, if any
	 */
	private List<File> replaces;

	@JsonProperty("file_id")
	public int getId() {
		return id;
	}

	@JsonProperty("file_id")
	public void setId(int id) {
		this.id = id;
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

	public MimeType getMimetype() {
		return mimetype;
	}

	public void setMimetype(MimeType mimetype) {
		this.mimetype = mimetype;
	}

	public FileReference getContext() {
		return context;
	}

	public void setContext(FileReference context) {
		this.context = context;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public List<File> getReplaces() {
		return replaces;
	}

	public void setReplaces(List<File> replaces) {
		this.replaces = replaces;
	}
}
