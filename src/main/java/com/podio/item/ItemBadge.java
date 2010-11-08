package com.podio.item;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.podio.rating.RatingType;
import com.podio.rating.RatingTypeKeyDeserializer;
import com.podio.rating.TypeRating;

public class ItemBadge {

	/**
	 * The id of the item
	 */
	private int id;

	/**
	 * The information on who created the first revision of the item
	 */
	private ItemRevision initialRevision;

	/**
	 * The latest revision
	 */
	private ItemRevision currentRevision;

	/**
	 * The title of the item. This is made of up one of the fields below, or by
	 * the item name and id
	 */
	private String title;

	/**
	 * The values for each field
	 */
	private List<FieldValues> fields;

	/**
	 * Number of comments on the item
	 */
	private int comments;

	/**
	 * The ratings on the item
	 */
	private Map<RatingType, TypeRating> ratings;

	/**
	 * The number of files on the item
	 */
	private int files;

	@JsonProperty("item_id")
	public int getId() {
		return id;
	}

	@JsonProperty("item_id")
	public void setId(int id) {
		this.id = id;
	}

	@JsonProperty("initial_revision")
	public ItemRevision getInitialRevision() {
		return initialRevision;
	}

	@JsonProperty("initial_revision")
	public void setInitialRevision(ItemRevision initialRevision) {
		this.initialRevision = initialRevision;
	}

	@JsonProperty("current_revision")
	public ItemRevision getCurrentRevision() {
		return currentRevision;
	}

	@JsonProperty("current_revision")
	public void setCurrentRevision(ItemRevision currentRevision) {
		this.currentRevision = currentRevision;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<FieldValues> getFields() {
		return fields;
	}

	public void setFields(List<FieldValues> fields) {
		this.fields = fields;
	}

	public Map<RatingType, TypeRating> getRatings() {
		return ratings;
	}

	@JsonDeserialize(keyUsing = RatingTypeKeyDeserializer.class)
	public void setRatings(Map<RatingType, TypeRating> ratings) {
		this.ratings = ratings;
	}

	public int getComments() {
		return comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}

	public int getFiles() {
		return files;
	}

	public void setFiles(int files) {
		this.files = files;
	}
}
