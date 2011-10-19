package com.podio.status;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.podio.comment.Comment;
import com.podio.file.File;
import com.podio.rating.RatingType;
import com.podio.rating.RatingTypeKeyDeserializer;
import com.podio.rating.RatingValuesMap;

/**
 * A status message posted by a user to a space
 */
public class StatusFull extends Status {

	/**
	 * All the comments on the status
	 */
	private List<Comment> comments;

	/**
	 * The ratings on the status
	 */
	private RatingValuesMap ratings;

	/**
	 * The files on the status
	 */
	private List<File> files;

	/**
	 * <code>true</code> if the user is subscribed to the item,
	 * <code>false</code> otherwise
	 */
	private boolean subscribed;

	/**
	 * The ratings and their values done by the active user on the status
	 */
	private Map<RatingType, Integer> userRatings;

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public RatingValuesMap getRatings() {
		return ratings;
	}

	public void setRatings(RatingValuesMap ratings) {
		this.ratings = ratings;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public boolean isSubscribed() {
		return subscribed;
	}

	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}

	public Integer getUserRating(RatingType type) {
		return userRatings.get(type);
	}

	public Map<RatingType, Integer> getUserRatings() {
		return userRatings;
	}

	@JsonDeserialize(keyUsing = RatingTypeKeyDeserializer.class)
	@JsonProperty("user_ratings")
	public void setUserRatings(Map<RatingType, Integer> userRatings) {
		this.userRatings = userRatings;
	}
}
