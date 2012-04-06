package com.podio.embed;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

import com.podio.file.File;

public class Embed {

	/**
	 * The id of the embed
	 */
	private int id;

	/**
	 * The url the user originally provided
	 */
	private String originalUrl;

	/**
	 * The final url after redirects (e.g. if the url was shortened link)
	 */
	private String resolvedUrl;

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
	 * When the embed was created
	 */
	private DateTime createdOn;

	/**
	 * The name of the linked service provider or website
	 */
	private String providerName;

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

	public void setId(int id) {
		this.id = id;
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	@JsonProperty("original_url")
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public String getResolvedUrl() {
		return resolvedUrl;
	}

	@JsonProperty("resolved_url")
	public void setResolvedUrl(String resolvedUrl) {
		this.resolvedUrl = resolvedUrl;
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

	public DateTime getCreatedOn() {
		return createdOn;
	}

	@JsonProperty("created_on")
	public void setCreatedOn(DateTime createdOn) {
		this.createdOn = createdOn;
	}

	public String getProviderName() {
		return providerName;
	}

	@JsonProperty("provider_name")
	public void setProviderName(String providerName) {
		this.providerName = providerName;
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
