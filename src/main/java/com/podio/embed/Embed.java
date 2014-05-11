package com.podio.embed;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.file.File;

public class Embed implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * The id of the embed
	 */
	private int id;

	/**
	 * The url for the embed
	 */
	private String url;

	/**
	 * The type of embed
	 */
	private EmbedType type;

	/**
	 * The title of the linked content
	 */
	private String title;

	/**
	 * An descriptive excerpt of the linked content
	 */
	private String description;

	/**
	 * HTML object extracted from the link that can be embedded as is
	 */
	private String embedHtml;

	/**
	 * Width of the embedded object
	 */
	private Integer embedWidth;

	/**
	 * Height of the embedded object
	 */
	private Integer embedHeight;

	/**
	 * Files that can be used as thumbnails for the embed (last is always
	 * favicon)
	 */
	private List<File> files;

	public int getId() {
		return id;
	}

	@JsonProperty("embed_id")
	public void setId(int id) {
		this.id = id;
	}
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public EmbedType getType() {
		return type;
	}

	public void setType(EmbedType type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmbedHtml() {
		return embedHtml;
	}

	@JsonProperty("embed_html")
	public void setEmbedHtml(String embedHtml) {
		this.embedHtml = embedHtml;
	}

	public Integer getEmbedWidth() {
		return embedWidth;
	}

	@JsonProperty("embed_width")
	public void setEmbedWidth(Integer embedWidth) {
		this.embedWidth = embedWidth;
	}

	public Integer getEmbedHeight() {
		return embedHeight;
	}

	@JsonProperty("embed_height")
	public void setEmbedHeight(Integer embedHeight) {
		this.embedHeight = embedHeight;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

}
