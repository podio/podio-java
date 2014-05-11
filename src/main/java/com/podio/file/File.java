package com.podio.file;

import java.util.List;

import javax.activation.MimeType;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.common.CreatedBase;

public class File extends CreatedBase {

	private static final long serialVersionUID = 1L;

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
	 * The URL where the file can be downloaded.
	 */
	private String link;
	
	/**
	 * The base link to the thumbnail of the file. Can be postfixed with the required size, one of:
	 * 
	 * tiny - 16x16
	 * small - 32x32
	 * default - 40x40
	 * medium - 80x80
	 * large - 160x160
	 */
	private String thumbnailLink;
	
	/**
	 * The link to the file with information on Podio.
	 */
	private String permaLink;

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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@JsonProperty("thumbnail_link")
	public String getThumbnailLink() {
		return thumbnailLink;
	}

	public void setThumbnailLink(String thumbnailLink) {
		this.thumbnailLink = thumbnailLink;
	}

	@JsonProperty("permalink_link")
	public String getPermaLink() {
		return permaLink;
	}

	public void setPermaLink(String permaLink) {
		this.permaLink = permaLink;
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
